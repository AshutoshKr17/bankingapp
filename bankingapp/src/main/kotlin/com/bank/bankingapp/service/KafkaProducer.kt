//package com.bank.bankingapp.service
//
//import com.bank.bankingapp.model.LoanApplication
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.stereotype.Service
//
//@Service
//class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, LoanApplication>) {
//
//    fun sendLoanApplication(application: LoanApplication) {
//        kafkaTemplate.send("loan-applications", application)
//    }
//}