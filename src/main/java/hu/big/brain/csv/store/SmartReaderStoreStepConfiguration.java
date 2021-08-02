package hu.big.brain.csv.store;

import hu.big.brain.csv.model.Person;
import hu.big.brain.csv.store.writer.SmartPersonWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SmartReaderStoreStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step smartReaderStoreStep(ItemReader<Person> batchDojoCsvReader,
                                     ItemProcessor<Person, Person> processor,
                                     SmartPersonWriter writer) {
        return stepBuilderFactory.get("smart-store")
                .<Person, Person>chunk(1)
                .reader(batchDojoCsvReader)
                .processor(processor)
                .listener(processor)
                .writer(writer)
                .faultTolerant()
                .skipLimit(3)
                .skip(Exception.class)
                .build();
    }
}
