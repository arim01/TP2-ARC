package emsi.ma.customerservice.web;

import emsi.ma.customerservice.Dao.entities.Customer;
import emsi.ma.customerservice.Dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    // a. Obtenir la liste des clients
    @GetMapping
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    // b. Obtenir un client par son identifiant
    @GetMapping("/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // c. Enregistrer un nouveau client
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
