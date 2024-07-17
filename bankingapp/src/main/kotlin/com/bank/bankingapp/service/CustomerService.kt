package com.bank.bankingapp.service

import com.bank.bankingapp.model.Customer
import com.bank.bankingapp.model.LoanApplication
import com.bank.bankingapp.model.Offer
import com.bank.bankingapp.repository.CustomerRepository
import com.bank.bankingapp.repository.LoanApplicationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class CustomerService (
    private val customerRepository: CustomerRepository,
    private val loanApplicationRepository: LoanApplicationRepository,
    private val offerService: OfferService
) {

    @Transactional
    fun createConsumer(customer: Customer): Mono<Customer> {
        return customerRepository.save(customer)
    }

    fun login(phoneNumber: String, dateOfBirth: String): Mono<Customer> {
        return customerRepository.findByPhoneNumberAndDateOfBirth(phoneNumber, dateOfBirth)
            .switchIfEmpty(Mono.error(Exception("User not found")))
    }
    fun submitKycDetails(phoneNumber: String, aadharNumber: String, address: String, salary: Double): Mono<Customer> {

        return customerRepository.findByPhoneNumber(phoneNumber)
            .flatMap { existingCustomer ->
                existingCustomer.aadharNumber = aadharNumber
                existingCustomer.address = address
                existingCustomer.salary = salary
                customerRepository.save(existingCustomer)
            }
            .switchIfEmpty(Mono.error(Exception("Customer not found")))
    }

    fun getLoanOffers(phoneNumber: String): Mono<List<Offer>> {
        return customerRepository.findByPhoneNumber(phoneNumber)
            .flatMap { customer ->
                offerService.getAllOffers().collectList()
            }
    }

    fun applyForLoan(phoneNumber: String, offerId: String): Mono<LoanApplication> {
        return customerRepository.findByPhoneNumber(phoneNumber)
            .flatMap { customer ->
                val loanApplication = LoanApplication(
                    customerId = customer.phoneNumber,
                    offerId = offerId,
                    status = "Pending",
                    comments = "Application under review"
                )
                loanApplicationRepository.save(loanApplication)
            }
            .switchIfEmpty(Mono.error(Exception("Customer not found")))
    }
}
