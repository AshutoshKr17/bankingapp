//package com.bank.bankingapp.service
//
//import com.bank.bankingapp.model.LoanApplication
//import com.bank.bankingapp.repository.LoanApplicationRepository
//import com.bank.bankingapp.repository.CustomerRepository
//import org.springframework.kafka.annotation.KafkaListener
//import org.springframework.stereotype.Service
//import reactor.core.publisher.Mono
//
//@Service
//class KafkaConsumer(
//    private val loanApplicationRepository: LoanApplicationRepository,
//    private val customerRepository: CustomerRepository,
//) {
//
//    @KafkaListener(topics = ["loan-applications"], groupId = "loan-applications-group")
//    fun consume(application: LoanApplication) {
//        println("Received loan application: $application")
//        customerRepository.findByPhoneNumber(application.customerId)
//            .flatMap { customer ->
//                val loanApplication = LoanApplication(
//                    customerId = application.customerId,
//                    offerId = application.offerId,
//                    status = "Pending",
//                    comments = "Application under review"
//                )
//                loanApplicationRepository.save(loanApplication)
//            }
//            .switchIfEmpty(Mono.error(Exception("Customer not found")))
//            .subscribe({
//                println("Loan application saved successfully")
//            }, {
//                println("Error saving loan application: ${it.message}")
//            })
//    }
//}
