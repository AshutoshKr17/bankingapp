package com.bank.bankingapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@ComponentScan("com.*.*")
@EnableReactiveMongoRepositories(basePackages = ["com.bank.bankingapp.repository"])
class BankingApplication


fun main(args: Array<String>) {
	runApplication<BankingApplication>(*args)
}
