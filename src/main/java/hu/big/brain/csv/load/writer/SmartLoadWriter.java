package hu.big.brain.csv.load.writer;

import hu.big.brain.csv.model.Person;
import hu.big.brain.csv.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SmartLoadWriter implements ItemWriter<Person> {

    private final PersonRepository personRepository;

    @Override
    public void write(List<? extends Person> list) throws Exception {
        list.forEach(personRepository::load);
    }
}
