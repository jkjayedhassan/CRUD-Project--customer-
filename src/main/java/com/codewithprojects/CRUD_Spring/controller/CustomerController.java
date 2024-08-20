package com.codewithprojects.CRUD_Spring.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithprojects.CRUD_Spring.entity.Customer;
import com.codewithprojects.CRUD_Spring.service.CustomerService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    @GetMapping("/customers")
    private List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable Long id) {
        Customer customer = customerService.getCustomersById(id);
        if (customer == null)
            ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);

    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updaCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer exitingCustomer = customerService.getCustomersById(id);
        if (exitingCustomer == null)
            return ResponseEntity.notFound().build();
        exitingCustomer.setName(customer.getName());
        exitingCustomer.setEmail(customer.getEmail());
        exitingCustomer.setPhone(customer.getPhone());
        Customer updatedCustomer = customerService.updaCustomer(exitingCustomer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerService.getCustomersById(id);                                                                       // CustomerService
        if (existingCustomer == null) 
            return ResponseEntity.notFound().build();
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
