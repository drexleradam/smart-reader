package hu.big.brain.csv.clean;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Log4j2
public class SmartCleanTasklet implements Tasklet {
	
	@Value("${fileName}")
	private String fileName;
	
	@Value("${dump-data-file-name}")
	private String dumpFileName;
	
	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
		deleteFileIfExists(fileName);
		deleteFileIfExists(dumpFileName);
		return RepeatStatus.FINISHED;
	}
	
	private void deleteFileIfExists(String fileName) {
		File file = new File(fileName);
		boolean deleted = file.delete();
		if (!deleted) {
			log.warn("Could not delete file {}", file.getAbsolutePath());
		} else {
			log.info("Deleted file {}", file.getAbsolutePath());
		}
	}
	
}
