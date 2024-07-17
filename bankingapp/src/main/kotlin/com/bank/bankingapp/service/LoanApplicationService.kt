package com.bank.bankingapp.service

import com.bank.bankingapp.model.LoanApplication
import com.bank.bankingapp.repository.LoanApplicationRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class LoanApplicationService(private val loanApplicationRepository: LoanApplicationRepository) {

    fun getApplications(product: String?, pan: String?, applicationId: String?): Flux<LoanApplication> {
        return loanApplicationRepository.findAll()
    }

    fun reviewApplication(applicationId: String, status: String, comments: String): Mono<LoanApplication> {
        return loanApplicationRepository.findById(applicationId)
            .flatMap {
                it.status = status
                it.comments = comments
                loanApplicationRepository.save(it)
            }
    }
}
