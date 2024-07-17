package com.bank.bankingapp.controller

import com.bank.bankingapp.model.LoanApplication
import com.bank.bankingapp.model.OfficeUser
import com.bank.bankingapp.service.OfficeUserService
import com.bank.bankingapp.service.LoanApplicationService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/officers")
@CrossOrigin(origins = ["http://localhost:3000"])
class OfficeUserController(
    private val officeUserService: OfficeUserService,
    private val loanApplicationService: LoanApplicationService
) {

    data class LoginRequest(val userId: String, val password: String)
    data class ReviewRequest(val status: String, val comments: String)

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Mono<Boolean> {
        return officeUserService.login(loginRequest.userId, loginRequest.password)
    }

    @PostMapping("/create")
    fun createOfficeUser(@RequestBody officeUser: OfficeUser): Mono<OfficeUser> {
        return officeUserService.createOfficeUser(officeUser)
    }


    @GetMapping("/applications")
    fun getLoanApplications(
        @RequestParam(required = false) product: String?,
        @RequestParam(required = false) pan: String?,
        @RequestParam(required = false) applicationId: String?
    ) = loanApplicationService.getApplications(product, pan, applicationId)

    @PostMapping("/applications/{id}/review")
    fun reviewApplication(@PathVariable id: String, @RequestBody reviewRequest: ReviewRequest): Mono<LoanApplication> {
        return loanApplicationService.reviewApplication(id, reviewRequest.status, reviewRequest.comments ?: "")
    }
}
