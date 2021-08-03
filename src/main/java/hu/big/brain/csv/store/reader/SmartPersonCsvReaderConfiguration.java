package hu.big.brain.csv.store.reader;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SmartPersonCsvReaderConfiguration {

    private String fileName;

    @Bean
    @StepScope
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

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        fileName = stepExecution
                .getJobExecution()
                .getExecutionContext()
                .getString("fileName");
    }

}
