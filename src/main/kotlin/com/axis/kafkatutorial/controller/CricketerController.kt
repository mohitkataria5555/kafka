package com.axis.kafkatutorial.controller

import com.axis.kafkatutorial.kafka.CricketerService
import com.axis.kafkatutorial.kafka.KafkaCricketProducer
import com.axis.kafkatutorial.payload.Cricketer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class CricketerController (
    @Autowired
    private val cricketerService:CricketerService,
    private val kafkaCricketProducer: KafkaCricketProducer

) {

    @GetMapping("/all-cricketers")

    fun getAllCricketers(): Flux<Cricketer> {
        kafkaCricketProducer.findAllCricketers()
        return cricketerService.getAllCricketers()
    }
    @GetMapping("/cric/{id}")
    fun getCricketerById(@PathVariable id:String):Mono<Cricketer>{
        kafkaCricketProducer.getCricketerById(id)
        return cricketerService.getCricketerById(id)
    }

    @PostMapping("/add-cricketer")
    fun addAgent(@RequestBody cricketer: Cricketer):Mono<Cricketer>{
        kafkaCricketProducer.postCricketer(cricketer)

        return cricketerService.addCricketer(cricketer)
    }

    @PutMapping("/update-cricketer/{id}")
        fun updateCricketer(@PathVariable id: String, cricketer: Cricketer):Mono<Cricketer>{
        kafkaCricketProducer.updatedCricketer(cricketer)
            return cricketerService.updateCricketer(id,cricketer)
        }

    @DeleteMapping("/delete/{id}")
    fun deleteCricketer(@PathVariable id: String):Mono<Void>{
        return cricketerService.deleteCricketer(id)

    }


}
