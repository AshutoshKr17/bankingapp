package com.bank.bankingapp.service

import com.bank.bankingapp.model.OfficeUser
import com.bank.bankingapp.repository.OfficeUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class OfficeUserService(private val officeUserRepository: OfficeUserRepository) {
    fun createOfficeUser(officeUser: OfficeUser): Mono<OfficeUser> {
        return officeUserRepository.save(officeUser)
    }
    fun login(userId: String, password: String): Mono<Boolean> {
        return officeUserRepository.findByUserId(userId)
            .map { it.password == password }
            .defaultIfEmpty(false)
    }
}
