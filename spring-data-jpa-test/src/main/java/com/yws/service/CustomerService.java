package com.yws.service;

import com.yws.dao.CustomerRepsotory;
import com.yws.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepsotory customerRepsotory;

    public Customer getById(Integer id) {
        //getById
        //return customerRepsotory.getById(id);

        //findById
        Optional<Customer> optional = customerRepsotory.findById(id);
        Customer customer = optional.get();
        return customer;
    }


    public Customer getCustomerWithGraphById(Integer id) {
        return customerRepsotory.findWithGraph(id, "customer-with-orders-and-details");
    }
}
