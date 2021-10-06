package hu.big.brain.csv.clean;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartCleanStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step smartCleanStep(SmartCleanTasklet tasklet) {
        return stepBuilderFactory.get("smart-clean")
                .tasklet(tasklet)
                .build();
    }
}
