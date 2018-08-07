package be.bo.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="be.bo.booking")
@PropertySource(value = { "classpath:application.properties" })
public class BookingConfig
{
 @Autowired
 private Environment env;
 
 @Bean
 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
 {
   return new PropertySourcesPlaceholderConfigurer();
 }
}
 
