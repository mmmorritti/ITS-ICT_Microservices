package org.mmmorritti.customer.controllers;

import org.mmmorritti.customer.models.Customer;
import org.mmmorritti.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v2/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //get
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long customerId){
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if(customerOpt.isPresent()){
            return customerOpt.get();
        }else{
            return null;
        }
    }

    //set customer
    @RequestMapping(method = RequestMethod.PUT)
    public void setCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);//save
        System.out.println(customer);
    }

    //edit customer
    @RequestMapping(value = "/{customerId}", method = RequestMethod.POST)
    public Customer editCustomer(@RequestBody Customer customer, @PathVariable int customerId){
        return customerRepository.save(customer);
    }

    //delete customer by ID
    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomerByID(@PathVariable Long customerId){
        customerRepository.deleteById(customerId);
    }

    //delete all customer
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

}
