package hu.big.brain.csv.dump.writer;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class SmartDumpWriterConfiguration {
	
	@Value("${dump-data-file-name}")
	private String fileName;
	
	@Bean
	public FlatFileItemWriter<Person> buildSmartDumpWriter() {
		return new FlatFileItemWriterBuilder<Person>()
				.name("smart-dump-csv-writer")
				.resource(new FileSystemResource(fileName))
				.delimited()
				.delimiter(DelimitedLineTokenizer.DELIMITER_TAB)
				.names("firstName", "lastName", "age")
				.build();
	}
	
}
