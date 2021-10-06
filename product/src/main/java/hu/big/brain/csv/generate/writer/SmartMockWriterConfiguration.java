package hu.big.brain.csv.generate.writer;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class SmartMockWriterConfiguration {

    @Value("${fileName}")
    private String fileName;

    @Bean
    public FlatFileItemWriter<Person> buildSmartMockWriter() {
        return new FlatFileItemWriterBuilder<Person>()
                .name("smart-mock-csv-writer")
                .resource(new FileSystemResource(fileName))
                .delimited()
                .delimiter(DelimitedLineTokenizer.DELIMITER_TAB)
                .names("firstName", "lastName", "age")
                .build();
    }

}
