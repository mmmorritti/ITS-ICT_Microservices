package org.mmmorritti.customer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.mmmorritti.customer.models.Customer;
import org.mmmorritti.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping(value = "/v2/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //get
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long customerId){
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if(customerOpt.isPresent()){
            log.info("Get customer");
            return customerOpt.get();
        }else{
            log.warn("Customer not found");
            return null;
        }
    }

    //get all
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomer() {
        log.info("Get all customer");
        return customerRepository.findAll();
    }

    //set customer
    @RequestMapping(method = RequestMethod.PUT)
    public void setCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);//save
        System.out.println(customer);
        log.info("Save customer");
    }

    //edit customer
    @RequestMapping(value = "/{customerId}", method = RequestMethod.POST)
    public Customer editCustomer(@RequestBody Customer customer, @PathVariable Long customerId){
        log.info("Edit customer");
        return customerRepository.save(customer);
    }

    //delete customer by ID
    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomerByID(@PathVariable Long customerId){
        customerRepository.deleteById(customerId);
        log.warn("Delete customer");
    }

    //delete all customer
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        log.warn("Delete customer");
        customerRepository.deleteAll();
    }

}
