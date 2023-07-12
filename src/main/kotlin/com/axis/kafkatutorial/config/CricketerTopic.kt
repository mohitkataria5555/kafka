package com.axis.kafkatutorial.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class CricketerTopic {

    @Bean
    fun cricTopic():NewTopic{
        return TopicBuilder.name("cricket")
            .partitions(2).build()
    }

}