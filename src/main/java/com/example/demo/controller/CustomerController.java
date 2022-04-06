package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/viewAllCustomers")
    public ModelAndView getAllCustomers()  {

        List<Customer> customerList = new ArrayList<>();
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(2).username("username2").city("city2").country("country2").build());

        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/customerById/{id}")
    public ModelAndView CustomersById(@PathVariable Integer id){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(2).username("username2").city("city2").country("country2").build());

        Customer customer1 = null;
        for(Customer customer: customerList){
            if(customer.getId() == id)
                customer1=customer;
        }
        ModelAndView modelAndView = new ModelAndView("ViewPageById");
        modelAndView.addObject("customer", customer1);
        return modelAndView;
    }

    @GetMapping("/customerByUsername/{username}")
    public ModelAndView CustomersByUsername(@PathVariable String username){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(2).username("username2").city("city2").country("country2").build());

        for(Customer customer: customerList){
            if(customer.getUsername() != username)
                customerList.remove(customer);
        }
        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }


    @GetMapping("/customerByCountry/{country}")
    public ModelAndView CustomersByCountry(@PathVariable String country){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(2).username("username2").city("city2").country("country2").build());

        for(Customer customer: customerList){
            if(customer.getCountry() != country)
                customerList.remove(customer);
        }
        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }


    @GetMapping("/customerByCity/{city}")
    public ModelAndView CustomersByCity(@PathVariable String city){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(1).username("username1").city("city1").country("country1").build());
        customerList.add(Customer.builder().id(2).username("username2").city("city2").country("country2").build());
        for(Customer customer: customerList){
            if(customer.getCity() != city)
                customerList.remove(customer);
        }
        ModelAndView modelAndView = new ModelAndView("ViewPage");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }



}
