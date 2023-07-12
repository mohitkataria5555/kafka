package com.axis.kafkatutorial.kafka

import com.axis.kafkatutorial.payload.Cricketer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class KafkaCricketProducer (

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Cricketer>,
    private val logger: Logger = LoggerFactory.getLogger(KafkaCricketProducer::class.java)
        )

{
    fun postCricketer(cricketer: Cricketer){
        logger.info(String.format("Cricketer sent ==> $cricketer"))
        var msg:Message<String> = MessageBuilder.withPayload("Added new Cricketer -> ${cricketer.toString()}")
            .setHeader(KafkaHeaders.TOPIC,"cricket").build()

        kafkaTemplate.send(msg)

    }

    fun findAllCricketers(){
        logger.info(String.format("Getting All Cricketers"))

        var msg:Message<String> = MessageBuilder.withPayload("Finding All Cricketers")
            .setHeader(KafkaHeaders.TOPIC,"cricket")
            .build()

        kafkaTemplate.send(msg)
    }

    fun getCricketerById(id: String){
        logger.info(String.format("Get Cricketer By Id:$id"))
        var msg:Message<String> = MessageBuilder.withPayload("Find Cricketer with ID: $id")
            .setHeader(KafkaHeaders.TOPIC,"cricket")
            .build()
        kafkaTemplate.send(msg)
    }
    fun updatedCricketer(cricketer: Cricketer){
        logger.info(String.format("Updated Cricketer Details -> $cricketer"))

        var msg:Message<String> = MessageBuilder.withPayload("Updated Cricketer -> ${cricketer.toString()}")
            .setHeader(KafkaHeaders.TOPIC,"cricket")
            .build()

        kafkaTemplate.send(msg)
    }



}