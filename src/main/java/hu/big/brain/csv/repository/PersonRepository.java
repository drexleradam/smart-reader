package hu.big.brain.csv.repository;

import hu.big.brain.csv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private String getStorePersonToDatabaseQuery() {
        return "insert into smart_person(first_name,last_name,age) values (:firstName,:lastName,:age) ON CONFLICT DO NOTHING";
    }

    private String getLoadPersonIntoDatabaseQuery() {
        return "insert into smart_mock_data(first_name,last_name,age) values (:firstName,:lastName,:age) ON CONFLICT DO NOTHING";
    }

    public void save(Person person) {
        jdbcTemplate.update(
                getStorePersonToDatabaseQuery(),
                new BeanPropertySqlParameterSource(person));
    }

    public void load(Person person) {
        jdbcTemplate.update(
                getLoadPersonIntoDatabaseQuery(),
                new BeanPropertySqlParameterSource(person));
    }
}
