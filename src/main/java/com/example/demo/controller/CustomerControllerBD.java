package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerControllerBD {
    CustomerRepository customerRepository;

    @GetMapping("/viewAllCustomersDB")
    public ModelAndView getAllCustomers()  {

        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers",customerRepository.findAll());
        return modelAndView;

    }

    @GetMapping("/customerBD/{id}")
    public ModelAndView getCustomersById(@PathVariable Integer id)  {

        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers",customerRepository.getById(id));
        return modelAndView;

    }


    @GetMapping("/customerByUsernameBD/{username}")
    public ModelAndView getCustomersByUsername(@PathVariable String username) {

        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerRepository.getAllByUsername(username));
        return modelAndView;

    }
    @GetMapping("/customerByCityBD/{city}")
    public ModelAndView getCustomersByCity(@PathVariable String city) {

        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerRepository.getAllByCity(city));
        return modelAndView;
    }


    @GetMapping("/customerByCountryBD/{country}")
    public ModelAndView getCustomersByCountry(@PathVariable String country) {

        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerRepository.getAllByCountry(country));
        return modelAndView;

    }
    }