package micro.doris.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class ConnectionConfig {
    @Value("${pcbs.datasource.url}")
    private String url;

    @Value("${pcbs.datasource.username}")
    private String username;

    @Value("${pcbs.datasource.password}")
    private String psw;

    @Value("${setMaximumPoolSize}")
    private Integer maximumPoolSize;

    @Value("${setMinimumIdle}")
    private Integer minimumIdle;

    @Value("${driverClassName}")
    private String driverClassName;

    @Bean
    DataSource dataSource(){

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setMinimumIdle(minimumIdle);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(psw);
        return new HikariDataSource(config);
    }

    @Bean
    JdbcTemplate jdbcTemplate() throws SQLException {
        return new JdbcTemplate(dataSource());

    }

}
