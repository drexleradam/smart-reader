package hu.big.brain.csv.apimarketplace;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MarketplaceSaveStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step marketplaceSaveStep(MarketplaceSaveTasklet tasklet) {
        return stepBuilderFactory.get("marketplace-api-save")
                .tasklet(tasklet)
                .build();
    }

}
