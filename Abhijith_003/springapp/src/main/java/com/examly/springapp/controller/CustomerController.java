package com.examly.springapp.controller;

import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*") // Allows React/Angular to connect
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Customer> getAllCustomers() { return customerService.getAllCustomers(); }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer c = customerService.getCustomerById(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Customer updated = customerService.updateCustomer(id, customer);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Customer>> getCustomersPaginated(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(customerService.getCustomersWithPagination(page, size));
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String email) {
        Customer c = customerService.getCustomerByEmail(email);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with email: " + email);
    }

    @GetMapping("/creditScore/{creditScore}")
    public ResponseEntity<?> getCustomersByCreditScore(@PathVariable Double creditScore) {
        List<Customer> list = customerService.getCustomersByCreditScore(creditScore);
        return list.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customers found") : ResponseEntity.ok(list);
    }
}