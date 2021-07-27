package hu.big.brain.csv.reader;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

@Component
public class SmartPersonCsvReader extends FlatFileItemReader<Person> {

    public SmartPersonCsvReader() {
        this.setName("smart-person-csv-reader");
        this.setLineMapper(new DefaultLineMapper<>());
        this.setResource(new PathResource("feladat_1.csv"));
        this.setLinesToSkip(1);
        DefaultLineMapper<Person> mapper = new DefaultLineMapper<>();
        mapper.setFieldSetMapper(new SmartPersonFieldSetter());
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter("\t");
        tokenizer.setNames("first_name", "last_name", "age");
        mapper.setLineTokenizer(tokenizer);
        this.setLineMapper(mapper);
    }

}
