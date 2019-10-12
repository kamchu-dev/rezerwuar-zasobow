package hackathon.rezerwuator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("hackathon.rezerwuator")
public class JpaConfig {
}
