package com.axis.kafkatutorial.kafka

import com.axis.kafkatutorial.payload.Cricketer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaCricketConsumer(
    private val logger: Logger = LoggerFactory.getLogger(KafkaCricketConsumer::class.java)
) {

    @KafkaListener(topics = ["cricket"], groupId = "cricketGroup")
    fun consumePostedAgent(cricketer: Cricketer){
        logger.info(String.format("Details Received \n ${cricketer.toString()}"))
    }


}