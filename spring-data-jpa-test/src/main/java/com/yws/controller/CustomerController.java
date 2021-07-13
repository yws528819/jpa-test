package com.yws.controller;


import com.yws.entity.Customer;
import com.yws.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {
        Customer customer = customerService.getById(id);
        System.out.println(customer.getCustomerName());
        System.out.println(customer.getOrders());
        Customer retCus = new Customer();
        //BeanUtils.copyProperties(customer, retCus);
        return retCus;
    }


    @GetMapping("/{id}/orders")
    public Customer getCustomerWithOrders(@PathVariable("id") Integer id) {
        Customer customer = customerService.getCustomerWithGraphById(id);
        customer.getOrders().stream().forEach(e -> {
            System.out.println(e.toString());
        });


        Customer retCus = new Customer();
        BeanUtils.copyProperties(customer, retCus);
        return retCus;
    }

    @GetMapping("/{id}/orders/orderdetail")
    public Customer getCustomerWithOrdersAndOrderDetails(@PathVariable("id") Integer id) {
        Customer customer = customerService.getCustomerWithGraphById(id);

        customer.getOrders().stream().forEach(e -> {
            System.out.println(e);

            e.getOrderDetail().stream().forEach(e1 -> {
                System.out.println(e1);
            });
        });

        Customer retCus = new Customer();
        BeanUtils.copyProperties(customer, retCus);
        return retCus;
    }
}
