package hu.big.brain.csv.writer;

import hu.big.brain.csv.model.Person;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SmartPersonPostgresWriter extends JdbcBatchItemWriter<Person> {

    public SmartPersonPostgresWriter(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql("insert into smart_person(first_name,last_name,age) values (:firstName,:lastName,:age);");
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
    }
}
