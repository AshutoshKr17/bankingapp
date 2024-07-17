package com.bank.bankingapp.repository

import com.bank.bankingapp.model.OfficeUser
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface OfficeUserRepository : ReactiveMongoRepository<OfficeUser, String> {
    fun findByUserId(userId: String): Mono<OfficeUser>
}
