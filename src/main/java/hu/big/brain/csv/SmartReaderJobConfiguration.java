package hu.big.brain.csv;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class SmartReaderJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job smartReaderJob(Step smartReaderStoreStep) {
        return jobBuilderFactory.get("smart-load-table-to-table")
                .incrementer(new RunIdIncrementer())
                .start(smartReaderStoreStep)
                .build();
    }

}