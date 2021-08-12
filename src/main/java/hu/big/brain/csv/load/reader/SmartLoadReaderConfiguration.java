package hu.big.brain.csv.load.reader;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@Configuration
public class SmartLoadReaderConfiguration {

    @Value("${dump-data-file-name}")
    private String fileName;

    @Bean
    @StepScope
    FlatFileItemReader<Person> loadPersonReader(DataSource dataSource) {
        return new FlatFileItemReaderBuilder<Person>()
                .name("smart-load-data-reader")
                .resource(new FileSystemResource(fileName))
                .delimited()
                .delimiter(DelimitedLineTokenizer.DELIMITER_TAB)
                .names("firstName", "lastName", "age")
                .targetType(Person.class)
                .build();
    }


}
