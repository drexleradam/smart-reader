package hu.big.brain.csv.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DumpDataSourceConfiguration {

    @Bean
    @ConditionalOnProperty("dump-datasource.url")
    @ConfigurationProperties("dump-datasource")
    public DataSourceProperties dumpDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConditionalOnBean(name = "dumpDataSourceProperties")
    public HikariDataSource dumpDataSource(@Qualifier("dumpDataSourceProperties") DataSourceProperties dumpDataSourceProperties) {
        return dumpDataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

}
