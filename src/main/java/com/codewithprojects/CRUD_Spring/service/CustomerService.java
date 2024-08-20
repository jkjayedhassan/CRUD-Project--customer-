package com.codewithprojects.CRUD_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithprojects.CRUD_Spring.entity.Customer;
import com.codewithprojects.CRUD_Spring.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

   private final CustomerRepository customerRepository;

   public Customer postCustomer(Customer customer) {
      return customerRepository.save(customer);
   }

   public List<Customer> getAllCustomers() {
      return customerRepository.findAll();
   }

   public Customer getCustomersById(Long id) {
      return customerRepository.findById(id).orElse(null);
   }

   public Customer updaCustomer(Customer customer) {
      return customerRepository.save(customer);
   }

   public void deleteCustomer(Long id) {
      customerRepository.deleteById(id);
   }
}
