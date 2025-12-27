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

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    public Customer updateCustomer(int id, Customer customer) {
        customer.setCustomerId(id);
        return customerRepo.save(customer);
    }

    public Page<Customer> getCustomersByPage(int offset, int pageSize) {
        return customerRepo.findAll(PageRequest.of(offset, pageSize, Sort.unsorted()));
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepo.findByEmail(email).orElse(null);
    }

    public List<Customer> getCustomersByCreditScore(Double score) {
        return customerRepo.findByCreditScoreGreaterThanEqual(score);
    }
}