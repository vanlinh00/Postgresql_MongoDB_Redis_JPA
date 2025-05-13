package com.example.Postgresql_MongoDB_Redis_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class PostgresqlMongoDbRedisJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlMongoDbRedisJpaApplication.class, args);
	}

}
