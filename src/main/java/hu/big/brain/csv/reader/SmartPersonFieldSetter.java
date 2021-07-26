package hu.big.brain.csv.reader;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class SmartPersonFieldSetter implements FieldSetMapper<Person> {
    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        return Person
                .builder()
                .firstName(fieldSet.readString("first_name"))
                .lastName(fieldSet.readString("last_name"))
                .age(fieldSet.readInt("age"))
                .build();
    }
}
