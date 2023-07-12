package com.axis.kafkatutorial.payload

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("cricketers")
data class Cricketer (
@Id
    val id:String,
    val name:String,
    val team:String,
    val age:String



        )