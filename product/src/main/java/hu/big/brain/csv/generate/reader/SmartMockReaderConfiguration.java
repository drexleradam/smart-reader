package hu.big.brain.csv.generate.reader;

import hu.big.brain.csv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class SmartMockReaderConfiguration {

    @Bean
    JdbcPagingItemReader<Person> buildPagingItemReader(DataSource dataSource) {
        JdbcPagingItemReaderBuilder<Person> builder = new JdbcPagingItemReaderBuilder<Person>()
                .name("smart-mock-data-reader")
                .rowMapper(BeanPropertyRowMapper.newInstance(Person.class))
                .selectClause("id,first_name,last_name,age")
                .fromClause("smart_mock_data")
                .sortKeys(Collections.singletonMap("id", Order.ASCENDING))
                .dataSource(dataSource);
        return builder.build();
    }


}
