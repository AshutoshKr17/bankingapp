//package com.bank.bankingapp.config
//
//import org.apache.kafka.clients.admin.NewTopic
//import org.apache.kafka.clients.producer.ProducerConfig
//import org.apache.kafka.common.serialization.StringSerializer
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.kafka.annotation.EnableKafka
//import org.springframework.kafka.core.DefaultKafkaProducerFactory
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.kafka.core.ProducerFactory
//import org.springframework.kafka.support.serializer.JsonSerializer
//
//@EnableKafka
//@Configuration
//class KafkaConfig {
//
//    @Bean
//    fun producerFactory(): ProducerFactory<String, Any> {
//        val configProps = hashMapOf<String, Any>(
//            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
//            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
//            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
//        )
//        return DefaultKafkaProducerFactory(configProps)
//    }
//
//    @Bean
//    fun kafkaTemplate(): KafkaTemplate<String, Any> {
//        return KafkaTemplate(producerFactory())
//    }
//
//    @Bean
//    fun topic(): NewTopic {
//        return NewTopic("loanApplications", 1, 1.toShort())
//    }
//}
