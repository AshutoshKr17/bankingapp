package com.bank.bankingapp.config
//
//import com.mongodb.reactivestreams.client.MongoClients
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate
//import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
//
//
//@Configuration
//class MongoDBConfig {
//    @Bean
//    fun reactiveMongoDatabaseFactory(): ReactiveMongoDatabaseFactory {
//        return SimpleReactiveMongoDatabaseFactory(MongoClients.create(), "Bank")
//    }
//
//
//    @Bean
//    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
//        return ReactiveMongoTemplate(reactiveMongoDatabaseFactory())
//    }
//}