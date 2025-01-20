package com.itv.ITV205FirstSpringbootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itv.ITV205FirstSpringbootApp.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
