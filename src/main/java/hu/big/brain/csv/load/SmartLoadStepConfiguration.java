package hu.big.brain.csv.load;

import hu.big.brain.csv.load.writer.SmartLoadWriter;
import hu.big.brain.csv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartLoadStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step smartLoadStep(ItemReader<Person> loadPersonReader,
                              SmartLoadWriter writer) {
        return stepBuilderFactory.get("smart-load")
                .<Person, Person>chunk(1)
                .reader(loadPersonReader)
                .writer(writer)
                .faultTolerant()
                .skipLimit(3)
                .skip(Exception.class)
                .build();
    }
}
