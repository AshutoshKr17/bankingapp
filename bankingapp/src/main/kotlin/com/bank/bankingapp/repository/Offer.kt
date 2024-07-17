package com.bank.bankingapp.repository

import com.bank.bankingapp.model.Offer
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OfferRepository : ReactiveCrudRepository<Offer, String>
