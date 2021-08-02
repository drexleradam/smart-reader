package hu.big.brain.csv.store.reader;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SmartPersonCsvReaderConfiguration {

    @Value("${fileName}")
    private String fileName;

    @Bean
    public FlatFileItemReader<Person> batchDojoCsvReader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("smart-person-csv-reader")
                .resource(new ClassPathResource(fileName))
                .delimited()
                .delimiter(DelimitedLineTokenizer.DELIMITER_TAB)
                .names("first_name", "last_name", "age")
                .targetType(Person.class)
                .linesToSkip(1)
                .build();
    }

}
