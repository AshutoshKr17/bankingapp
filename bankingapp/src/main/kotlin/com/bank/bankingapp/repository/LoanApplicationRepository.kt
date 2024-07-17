package com.bank.bankingapp.repository

import com.bank.bankingapp.model.LoanApplication
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LoanApplicationRepository : ReactiveMongoRepository<LoanApplication, String>
