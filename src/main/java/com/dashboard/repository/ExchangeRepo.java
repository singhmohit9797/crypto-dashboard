package com.dashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.entity.Exchange;

@Repository
public interface ExchangeRepo extends CrudRepository<Exchange, String>{

}
