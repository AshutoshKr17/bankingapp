package com.bank.bankingapp.model

//import jakarta.persistence.GeneratedValue
//import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate


@Document(collection = "customers")
data class Customer(
    @Id val id: String? = null,
    val phoneNumber: String,
    val dateOfBirth: String,
    var salary : Double? = null,
    var address: String? = null,
    var aadharNumber: String? = null
)
