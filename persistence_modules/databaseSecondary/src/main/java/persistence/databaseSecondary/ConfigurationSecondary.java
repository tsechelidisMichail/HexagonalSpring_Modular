package persistence.databaseSecondary;

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
@PropertySource({"classpath:application-databaseSecondary.properties"})
@EnableJpaRepositories(
        basePackages = "persistence.databaseSecondary",
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager"
)
public class ConfigurationSecondary {

        @Autowired
        private Environment env;

        @Bean
        public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(secondaryDataSource());
            em.setPackagesToScan(
                    new String[]{"persistence.databaseSecondary"});

            HibernateJpaVendorAdapter vendorAdapter
                    = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            HashMap<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto",
                    env.getProperty("spring.jpa.hibernate.ddl.auto"));
            em.setJpaPropertyMap(properties);

            return em;
        }

        @Bean(name = "secondaryDataSource")
        @ConfigurationProperties(prefix = "spring.datasource-secondary")
        public DataSource secondaryDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean(name = "secondaryTransactionManager")
        public PlatformTransactionManager secondaryTransactionManager() {
            JpaTransactionManager transactionManager
                    = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(
                    secondaryEntityManagerFactory().getObject());
            return transactionManager;
        }
}
