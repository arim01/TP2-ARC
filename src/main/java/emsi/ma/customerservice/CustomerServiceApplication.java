package emsi.ma.customerservice;

import emsi.ma.customerservice.Dao.entities.Customer;
import emsi.ma.customerservice.Dao.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= "emsi.ma.customerservice.Dao.repository")
@EntityScan(basePackages="emsi.ma.customerservice.Dao.entities")
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder().name("X").email("X@gmail.com").build());
			customerRepository.save(Customer.builder().name("Y").email("Y@gmail.com").build());
		};
	}

	//le dernier test se fait par : http://localhost:8082/api/customers
}
