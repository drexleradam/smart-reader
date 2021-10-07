package hu.big.brain.csv.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PrimaryDataSourceConfiguration {
	
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@Primary
	public HikariDataSource dataSource(DataSourceProperties dumpDataSourceProperties) {
		return dumpDataSourceProperties
				.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
	
	@Bean
	@Primary
	@ConditionalOnBean(name = "dataSource")
	public NamedParameterJdbcTemplate remoteNamedParameterJdbcTemplate(DataSource remoteDataSource) {
		return new NamedParameterJdbcTemplate(remoteDataSource);
	}
	
}
