package com.bank.bankingapp.controller

import com.bank.bankingapp.model.Offer
import com.bank.bankingapp.service.OfferService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/offers")
@CrossOrigin(origins = ["http://localhost:3000"])
class OfferController(private val offerService: OfferService) {

    @GetMapping
    fun getAllOffers(): Flux<Offer> {
        return offerService.getAllOffers()
    }

    @PostMapping
    fun createOffer(@RequestBody offer: Offer): Mono<Offer> {
        return offerService.saveOffer(offer)
    }
}
