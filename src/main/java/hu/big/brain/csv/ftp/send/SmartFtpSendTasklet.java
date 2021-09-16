package hu.big.brain.csv.ftp.send;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Log4j2
@Component
@RequiredArgsConstructor
public class SmartFtpSendTasklet implements Tasklet {

    private final FTPClient client;
    private String dumpPath;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Connecting to ftp server ...");
        client.connect("localhost", 21);
        boolean connected = client.login("test", "test");
        log.info("Is connected {}", connected);
        client.enterLocalPassiveMode();
        log.info("Entered local passive mode.");
        FTPFile[] files = client.listFiles();
        log.debug("Found {} files.", files.length);
        boolean stored = client.storeFile("tmp.txt", new FileInputStream(dumpPath));
        log.info("Did store file {}", stored);
        boolean loggedOut = client.logout();
        log.info("Is logged out {}", loggedOut);
        client.disconnect();
        return RepeatStatus.FINISHED;
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        dumpPath = stepExecution
                .getJobExecution()
                .getExecutionContext()
                .getString("fileName");
        log.info("file name is {}", dumpPath);
    }
}
