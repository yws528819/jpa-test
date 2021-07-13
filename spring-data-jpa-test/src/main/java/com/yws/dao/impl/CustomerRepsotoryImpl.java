package com.yws.dao.impl;

import com.yws.dao.BaseRepository;
import com.yws.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;


public class CustomerRepsotoryImpl implements BaseRepository<Customer, Integer> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Customer findWithGraph(Integer id, String graphyName) {

        EntityGraph entityGraph = entityManager.getEntityGraph(graphyName);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);

        Customer customer = entityManager.find(Customer.class, id, properties);
        return customer;
    }
}
