package com.kalavakuri.webmvc.business;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
public class BusinessConfig {

	@Profile("hikariDataSource")
	@Bean
	public DataSource hikariDataSource() {
		HikariConfig hikariConfig = new HikariConfig("/hikari.properties");
		DataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	@Profile("basicDataSource")
	@Bean("basicDataSource")
	public DataSource basicDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("SYSTEM");
		basicDataSource.setPassword("#knagamma1");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxTotal(100);

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
