package hu.big.brain.csv.load.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SmartLoadRepository {

    @Value("${dump-data-file-name}")
    private String fileName;

    private final JdbcTemplate jdbcTemplate;

    public void loadDumpIntoTable() {
        jdbcTemplate.execute(generateLoadSql());
    }

    private String generateLoadSql() {
        return new StringBuilder("copy smart_mock_data (first_name, last_name, age) FROM '")
                .append("/tmp/") // mount dir
                .append(fileName)
                .append("' WITH (FORMAT csv, DELIMITER E'\\t')")
                .toString();

    }
}
