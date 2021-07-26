package hu.big.brain.csv.processor;

import hu.big.brain.csv.model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SmartPersonProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) {
        String testFirstName = person.getFirstName().concat("_test");
        log.info("First name will be " + testFirstName + " for " + person);
        person.setFirstName(testFirstName);
        return person;
    }

}
