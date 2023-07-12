package com.axis.kafkatutorial.kafka

import com.axis.kafkatutorial.payload.Cricketer
import com.axis.kafkatutorial.repository.CricketerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CricketerService(private val cricketerRepository: CricketerRepository) {
    fun getAllCricketers(): Flux<Cricketer> {
        return cricketerRepository.findAll()
    }

    fun getCricketerById(id:String):Mono<Cricketer>{
        return cricketerRepository.findById(id)
    }

    fun addCricketer(cricketer: Cricketer):Mono<Cricketer>{
        return cricketerRepository.save(cricketer)
    }

    fun updateCricketer(id: String,updatedCricketer:Cricketer):Mono<Cricketer>{
        return cricketerRepository.findById(id)
            .flatMap {
                existingCricketer->
                val mergeCricketer=existingCricketer.copy(
                    name=updatedCricketer.name,
                    team = updatedCricketer.team,
                    age=updatedCricketer.age
                )
                cricketerRepository.save(mergeCricketer)
            }
    }

    fun deleteCricketer(id: String):Mono<Void>{
        return cricketerRepository.deleteById(id)
    }
}