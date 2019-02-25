package com.dashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.entity.Cryptocurrency;

@Repository
public interface CryptocurrencyRepo extends CrudRepository<Cryptocurrency, String>{

}
