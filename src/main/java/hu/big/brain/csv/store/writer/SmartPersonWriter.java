package hu.big.brain.csv.store.writer;

import hu.big.brain.csv.model.Person;
import hu.big.brain.csv.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SmartPersonWriter implements ItemWriter<Person> {

    private final PersonRepository personRepository;

    @Override
    public void write(List<? extends Person> list) {
        list.forEach(personRepository::save);
    }
}
