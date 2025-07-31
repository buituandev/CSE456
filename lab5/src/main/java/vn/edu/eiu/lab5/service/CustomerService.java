package vn.edu.eiu.lab5.service;

import org.springframework.stereotype.Service;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.repo.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
