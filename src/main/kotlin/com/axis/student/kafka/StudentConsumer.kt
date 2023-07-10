package com.axis.student.kafka

import com.axis.student.entity.PersonalDetails
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class StudentConsumer {

    private val logger = LoggerFactory.getLogger(StudentConsumer::class.java)

    @KafkaListener(topics = ["student"], groupId = "student-group")
    fun receivedDetails(personalDetails: PersonalDetails) {
        logger.info("Received details: $personalDetails")
    }
}