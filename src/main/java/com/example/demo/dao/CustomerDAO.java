package com.example.demo.dao;


import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerDAO implements DAO<CustomerDAO> {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<CustomerDAO> get(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void create(CustomerDAO customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(CustomerDAO customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(CustomerDAO customer) {
        customerRepository.save(customer);
    }
}
