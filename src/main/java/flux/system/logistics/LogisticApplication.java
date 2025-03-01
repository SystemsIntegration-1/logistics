package flux.system.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "flux.system.logistics.domain.entities")
@EnableJpaRepositories(basePackages = {"flux.system.logistics.domain.repositories"})
@SpringBootApplication
public class LogisticApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticApplication.class, args);
	}

}
