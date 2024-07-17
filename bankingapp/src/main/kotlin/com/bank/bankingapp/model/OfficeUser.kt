package com.bank.bankingapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "officeUsers")
data class OfficeUser(
    @Id val id: String? = null,
    val userId: String,
    val password: String,
    val role: String = "OFFICER"
)