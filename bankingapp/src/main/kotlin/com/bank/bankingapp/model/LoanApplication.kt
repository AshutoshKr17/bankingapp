package com.bank.bankingapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "loanApplications")
data class LoanApplication(
    @Id val id: String? = null,
    val customerId: String,
    val offerId: String,
    var status: String = "Pending",
    var comments: String? = null
)
