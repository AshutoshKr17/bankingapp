package com.bank.bankingapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "offers")
data class Offer(
    @Id
    val id: String,
    val description: String,
    val interestRate: Double,
    val tenure: Int,
    val amount: Double
)

