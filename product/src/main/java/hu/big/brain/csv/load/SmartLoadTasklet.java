package hu.big.brain.csv.load;

import hu.big.brain.csv.load.repository.SmartLoadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class SmartLoadTasklet implements Tasklet {
	
	private final SmartLoadRepository smartLoadRepository;
	
	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
		log.info("Loading dump into table");
		smartLoadRepository.loadDumpIntoTable();
		return RepeatStatus.FINISHED;
	}
}
