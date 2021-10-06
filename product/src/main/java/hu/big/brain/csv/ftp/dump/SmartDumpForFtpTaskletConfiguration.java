package hu.big.brain.csv.ftp.dump;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartDumpForFtpTaskletConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step smartDumpForFtpStep(SmartDumpForFtpTasklet tasklet) {
        return stepBuilderFactory
                .get("smart-ftp-dump")
                .tasklet(tasklet)
                .listener(tasklet)
                .build();
    }

}
