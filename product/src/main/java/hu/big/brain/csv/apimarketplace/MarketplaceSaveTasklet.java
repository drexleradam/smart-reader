package hu.big.brain.csv.apimarketplace;

import hu.big.brain.csv.apimarketplace.repository.MarketplaceRepository;
import hu.big.brain.csv.client.MockarooClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class MarketplaceSaveTasklet implements Tasklet {
	
	private final MockarooClient mockarooClient;
	private final MarketplaceRepository repository;
	
	@Value("${mockaroo.key}")
	String key;
	
	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
		log.info("requesting api call and saving results ...");
		mockarooClient.getMarketplace(key).forEach(repository::save);
		log.info("Done!");
		return RepeatStatus.FINISHED;
	}
}
