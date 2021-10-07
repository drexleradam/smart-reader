package hu.big.brain.csv.apilistingstatus;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ListingStatusSaveStepConfiguration {
	
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step listingStatusSaveStep(ListingStatusSaveTasklet tasklet) {
		return stepBuilderFactory.get("listing-status-api-save")
				.tasklet(tasklet)
				.build();
	}
	
}
