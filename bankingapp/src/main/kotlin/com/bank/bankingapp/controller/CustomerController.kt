package com.bank.bankingapp.controller

import com.bank.bankingapp.model.Customer
import com.bank.bankingapp.model.LoanApplication
import com.bank.bankingapp.model.Offer
import com.bank.bankingapp.service.CustomerService
import com.bank.bankingapp.service.LoanApplicationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono
//import com.bank.bankingapp.service.KafkaProducer

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = ["http://localhost:3000"])
class CustomerController(private val customerService: CustomerService,
                         private val loanApplicationService: LoanApplicationService,
                         /*private val kafkaProducer: KafkaProducer*/) {
    val offers = arrayOf("Offer1", "Offer2" , "Offer3");

    data class LoginRequest(val phoneNumber: String, val dateOfBirth: String)
    data class KycRequest(val aadharNumber: String, val address: String, val salary: Double)
    data class ApplyLoanRequest(val offerId: String)

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Mono<Customer> {
        return customerService.login(loginRequest.phoneNumber, loginRequest.dateOfBirth)
            .onErrorResume { Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, it.message)) }
    }

    @PostMapping("/create")
    fun createCustomer(@RequestBody request: Map<String, String>): Mono<Customer> {

        val phoneNumber = request["phoneNumber"]
        val dateOfBirth  = request["dateOfBirth"]

        if(phoneNumber == null || dateOfBirth == null) {
            return Mono.error(IllegalArgumentException("Phone number and date of birth are required"))
        }
        val customer = Customer(
            phoneNumber = phoneNumber,
            dateOfBirth = dateOfBirth
        )
        return customerService.createConsumer(customer)
    }

    @PostMapping("/{phoneNumber}/kyc")
    fun submitKycDetails(@PathVariable phoneNumber: String, @RequestBody kycRequest: KycRequest): Mono<Customer> {
        return customerService.submitKycDetails(phoneNumber, kycRequest.aadharNumber, kycRequest.address, kycRequest.salary)
    }

//    @GetMapping("/{phoneNumber}/offers")
//    fun getOffers(@PathVariable phoneNumber: String): Array<String> {
//        return offers;
//    }
    @GetMapping("/{phoneNumber}/offers")
    fun getOffers(@PathVariable phoneNumber: String): Mono<List<Offer>> {
        return customerService.getLoanOffers(phoneNumber)
    }
//
    @PostMapping("/{phoneNumber}/apply")
    fun applyForLoan(@PathVariable phoneNumber: String, @RequestBody request: Map<String, String>): Mono<LoanApplication> {
        val offerId = request["offerId"]
        if (offerId == null) {
            return Mono.error(IllegalArgumentException("Offer ID is required"))
        }
        return customerService.applyForLoan(phoneNumber, offerId)
    }

//    @PostMapping("/apply-loan")
//    fun applyForLoan(@PathVariable phoneNumber: String, @RequestBody request: Map<String, String>): Mono<LoanApplication> {
//            val offerId = request["offerId"]
//            if (offerId == null) {
//                return Mono.error(IllegalArgumentException("Offer ID is required"))
//            }
//            return kafkaProducer.sendLoanApplication(application)
//    }

}
