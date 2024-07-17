package com.bank.bankingapp.repository

import com.bank.bankingapp.model.Customer
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CustomerRepository : ReactiveMongoRepository<Customer, String> {
    fun findByPhoneNumberAndDateOfBirth(phoneNumber: String, dateOfBirth: String): Mono<Customer>
    fun findByPhoneNumber(phoneNumber: String): Mono<Customer>
}
