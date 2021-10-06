package hu.big.brain.csv.ftp.dump.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class DumpForFtpRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DumpForFtpRepository(@Qualifier("dumpNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void makeDump(String fileName) {
        namedParameterJdbcTemplate.execute("copy smart_remote_data to '/tmp/" + fileName + "'", PreparedStatement::execute);
    }

}
