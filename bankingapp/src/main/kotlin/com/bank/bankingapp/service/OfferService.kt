package com.bank.bankingapp.service

import com.bank.bankingapp.model.Offer
import com.bank.bankingapp.model.Customer
import com.bank.bankingapp.repository.OfferRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OfferService(private val offerRepository: OfferRepository) {

    fun getAllOffers(): Flux<Offer> {
        return offerRepository.findAll()
    }

    fun saveOffer(offer: Offer): Mono<Offer> {
        return offerRepository.save(offer)
    }

//    fun getOfferById(id: String): Mono<Offer> {
//        return offerRepository.findById(id)
//    }
}
