package com.david.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

/*
* 1: whats the type of entity JPA manage
* 2: whats the type of the Id field
* */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    // provide the search query
    ExchangeValue findByFromAndTo(String from, String to);
}
