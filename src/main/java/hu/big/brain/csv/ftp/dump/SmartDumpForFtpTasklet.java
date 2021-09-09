package hu.big.brain.csv.ftp.dump;

import hu.big.brain.csv.ftp.dump.repository.DumpForFtpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Log4j2
@Component
@RequiredArgsConstructor
public class SmartDumpForFtpTasklet implements Tasklet {

    private final DumpForFtpRepository repository;
    private String fileName;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        fileName = generateDumpPath();
        repository.makeDump(fileName);
        return RepeatStatus.FINISHED;
    }

    private String generateDumpPath() {
        return "ftp-dump-" + new Date().getTime() + ".txt";
    }

    @AfterStep
    public void afterStep(StepExecution stepExecution) {
        int number = new Random().nextInt(10)+1;
        log.info("Random number was {}", number);
        if (number >= 5) {
            stepExecution.setExitStatus(new ExitStatus("FTP","Need to upload to ftp."));
        }
        stepExecution
                .getJobExecution()
                .getExecutionContext()
                .put("fileName", fileName);
    }

}
