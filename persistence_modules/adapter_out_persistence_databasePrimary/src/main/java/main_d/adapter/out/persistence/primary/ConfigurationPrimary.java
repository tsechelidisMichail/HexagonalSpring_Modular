package main_d.adapter.out.persistence.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:application-databasePrimary.properties"})
@EnableJpaRepositories(
        basePackages = "main_d.adapter.out.persistence.primary",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
)
public class ConfigurationPrimary {

        @Autowired
        private Environment env;

        @Bean
        public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(primaryDataSource());
            em.setPackagesToScan(
                    new String[]{"main_d.adapter.out.persistence.primary"});

            HibernateJpaVendorAdapter vendorAdapter
                    = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            HashMap<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto",
                    env.getProperty("spring.jpa.hibernate.ddl.auto"));
            em.setJpaPropertyMap(properties);

            return em;
        }

        @Bean(name = "primaryDataSource")
        @ConfigurationProperties(prefix = "spring.datasource-primary")
        public DataSource primaryDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean(name = "primaryTransactionManager")
        public PlatformTransactionManager primaryTransactionManager() {
            JpaTransactionManager transactionManager
                    = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(
                    primaryEntityManagerFactory().getObject());
            return transactionManager;
        }
}
