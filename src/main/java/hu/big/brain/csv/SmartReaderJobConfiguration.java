package hu.big.brain.csv;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class SmartReaderJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final Step smartReaderDumpStep;
    private final Step smartLoadStep;
    private final Step smartMockGenerateStep;
    private final Step smartReaderStoreStep;
    private final Step smartCleanStep;
    private final Step listingStatusSaveStep;
    private final Step marketplaceSaveStep;
    private final Step smartDumpForFtpStep;
    private final Step smartFtpSendStep;

    @Bean
    public Job smartReaderJob() {
        return jobBuilderFactory.get("smart-dojo")
                .incrementer(new RunIdIncrementer())
                .start(smartFlow())
                .next(ftpFlow())
                .end()
                .build();
    }

    private Flow smartFlow() {
        return new FlowBuilder<SimpleFlow>("smart-previous-flow")
                .start(smartReaderDumpStep)
                .next(smartLoadStep)
                .next(smartMockGenerateStep)
                .next(smartReaderStoreStep)
                .next(listingStatusSaveStep)
                .next(marketplaceSaveStep)
                .end();
    }

    private Flow ftpFlow() {
        return new FlowBuilder<SimpleFlow>("smart-ftp-flow")
                .start(smartDumpForFtpStep)
                .on("FTP")
                .to(smartFtpSendStep)
                .on(ExitStatus.COMPLETED.getExitCode())
                .end()
                .from(smartDumpForFtpStep)
                .end();
    }

}
