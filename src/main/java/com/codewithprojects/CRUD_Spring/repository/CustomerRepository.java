package com.codewithprojects.CRUD_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithprojects.CRUD_Spring.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
