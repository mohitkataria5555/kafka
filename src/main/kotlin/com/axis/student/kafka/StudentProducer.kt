package com.axis.student.kafka

import com.axis.student.entity.PersonalDetails
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class StudentProducer (

    private val kafkaTemplate:KafkaTemplate<String , PersonalDetails>,
    ){

    private val logger =LoggerFactory.getLogger(StudentProducer::class.java)
    fun registerDetails(personalDetails: PersonalDetails){
        logger.info(String.format("New Details Registered"))
        kafkaTemplate.send("students", personalDetails.id.toString(), personalDetails)
    }
}