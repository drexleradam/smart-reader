package hu.big.brain.csv.ftp.send;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartFtpSendTaskletConfiguration {
	
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step smartFtpSendStep(SmartFtpSendTasklet tasklet) {
		return stepBuilderFactory
				.get("smart-ftp-upload")
				.tasklet(tasklet)
				.listener(tasklet)
				.build();
	}
	
}
