package com.axis.student.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class StudentTopic {

    fun studentTopic():NewTopic{
        return TopicBuilder.name("students")
            .build();
    }



}