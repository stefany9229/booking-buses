package com.example.bookingbuses.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "bookingEntityManagerFactory",
        transactionManagerRef = "bookingTransactionManager",
        basePackages = {
                "com.example.bookingbuses.model.IBookingRepository"
        }
)
public class BookingMySQLconfig {
    @Bean(name = "bookingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bookingEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookingEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("bookingDataSource") DataSource dataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.example.bookingbuses.model.Booking")
                .persistenceUnit("Booking")
                .build();
    }
}
