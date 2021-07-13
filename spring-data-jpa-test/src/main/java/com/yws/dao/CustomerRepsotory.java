package com.yws.dao;

import com.yws.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepsotory extends JpaRepository<Customer, Integer>, BaseRepository<Customer, Integer> {

}
