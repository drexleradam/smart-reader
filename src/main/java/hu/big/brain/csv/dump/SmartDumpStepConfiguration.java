package hu.big.brain.csv.dump;

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
public class SmartDumpStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step smartReaderDumpStep(@Qualifier("buildDumpPagingItemReader") JdbcPagingItemReader<Person> pagingItemReader,
                                     @Qualifier("buildSmartDumpWriter") FlatFileItemWriter<Person> writer) {
        return stepBuilderFactory.get("smart-dump")
                .<Person, Person>chunk(1)
                .reader(pagingItemReader)
                .writer(writer)
                .faultTolerant()
                .skipLimit(3)
                .skip(Exception.class)
                .build();
    }
}
