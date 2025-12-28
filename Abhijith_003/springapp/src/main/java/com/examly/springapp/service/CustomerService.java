package com.examly.springapp.service;

import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() { return customerRepo.findAll(); }

    public Customer getCustomerById(int id) { return customerRepo.findById(id).orElse(null); }

    public Customer updateCustomer(int id, Customer details) {
        return customerRepo.findById(id).map(customer -> {
            customer.setCustomerName(details.getCustomerName());
            customer.setEmail(details.getEmail());
            customer.setPhoneNumber(details.getPhoneNumber());
            customer.setAddress(details.getAddress());
            customer.setCreditScore(details.getCreditScore());
            return customerRepo.save(customer);
        }).orElse(null);
    }

    public boolean deleteCustomer(int id) {
        if(customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Customer> getCustomersWithPagination(int page, int size) {
        return customerRepo.findAll(PageRequest.of(page, size, Sort.by("customerName")));
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepo.findByEmail(email).orElse(null);
    }

    public List<Customer> getCustomersByCreditScore(Double creditScore) {
        return customerRepo.findByCreditScoreGreaterThanEqual(creditScore);
    }
}