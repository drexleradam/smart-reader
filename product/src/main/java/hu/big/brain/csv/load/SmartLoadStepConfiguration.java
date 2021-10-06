package hu.big.brain.csv.load;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartLoadStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step smartLoadStep(SmartLoadTasklet smartLoadTasklet) {
        return stepBuilderFactory
                .get("smart-load")
                .tasklet(smartLoadTasklet)
                .build();
    }
}
