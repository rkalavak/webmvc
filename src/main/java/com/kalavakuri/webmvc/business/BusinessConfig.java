package com.kalavakuri.webmvc.business;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan
@PropertySource("classpath:basicDataSource.properties")
public class BusinessConfig {

	@Autowired
	private Environment environment;

	@Profile("hikari_ds")
	@Bean
	public DataSource hikariDataSource() {
		HikariConfig hikariConfig = new HikariConfig("/hikari.properties");
		DataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	@Profile("basic_ds")
	@Bean
	public DataSource basicDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName(environment.getProperty("basicDataSource.driverClassName"));
		basicDataSource.setUrl(environment.getProperty("basicDataSource.url"));
		basicDataSource.setUsername(environment.getProperty("basicDataSource.userName"));
		basicDataSource.setPassword(environment.getProperty("basicDataSource.password"));
		basicDataSource.setInitialSize(Integer.parseInt(environment.getProperty("basicDataSource.initialSize")));
		basicDataSource.setMaxTotal(Integer.parseInt(environment.getProperty("basicDataSource.maxTotal")));

		return basicDataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
