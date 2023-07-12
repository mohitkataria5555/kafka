package com.axis.kafkatutorial.repository

import com.axis.kafkatutorial.payload.Cricketer
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CricketerRepository: ReactiveMongoRepository<Cricketer, String> {
}