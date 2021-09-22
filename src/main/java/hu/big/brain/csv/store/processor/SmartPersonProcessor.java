package hu.big.brain.csv.store.processor;

import hu.big.brain.csv.model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.annotation.AfterProcess;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SmartPersonProcessor implements ItemProcessor<Person, Person> {

    private static final String SUB_FIX = "_test";

    @Override
    public Person process(Person person) {
        Person person1 = new Person(person);
        person1.setFirstName(generateFirstName(person));
        return person1;
    }

    private String generateFirstName(Person person) {
        return person.getFirstName().concat(SUB_FIX);
    }

    @AfterProcess
    public void afterProcess(Person before, Person after) {
        log.info("First name was {}, now it is {}.", before.getFirstName(), after.getFirstName());
    }

}
