package hu.big.brain.csv.generate;

import hu.big.brain.csv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartMockGenerateStepConfiguration {
	
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step smartMockGenerateStep(@Qualifier("buildPagingItemReader") JdbcPagingItemReader<Person> pagingItemReader,
									  @Qualifier("buildSmartMockWriter") FlatFileItemWriter<Person> writer) {
		return stepBuilderFactory.get("smart-generate")
				.<Person, Person>chunk(1)
				.reader(pagingItemReader)
				.writer(writer)
				.faultTolerant()
				.skipLimit(3)
				.skip(Exception.class)
				.build();
	}
}
