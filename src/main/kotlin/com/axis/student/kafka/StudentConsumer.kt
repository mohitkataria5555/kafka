package com.axis.student.kafka

import com.axis.student.entity.PersonalDetails
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class StudentConsumer {

    private val logger : Logger = LoggerFactory.getLogger(StudentConsumer::class.java)

    @KafkaListener(topics = ["students"], groupId = "student-group")
    fun receivedDetails(personalDetails: PersonalDetails) {
     //   logger.info("Received details: ${personalDetails.toString()}")
        logger.info(String.format("Received details ${personalDetails.toString()}"))
    }
}