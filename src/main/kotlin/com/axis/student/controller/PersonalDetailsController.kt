package com.axis.student.controller

import com.axis.student.entity.PersonalDetails
import com.axis.student.kafka.StudentProducer
import com.axis.student.repo.PersonalDetailsRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/details")
class PersonalDetailsController (
    @Autowired
    private val personalRepository: PersonalDetailsRepository,
    private val studentProducer: StudentProducer

    ){

    @GetMapping("/")
    fun getAllDetails(): Flux<PersonalDetails> {
        return personalRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getDetailById(@PathVariable id:String):Mono<PersonalDetails>{
        return personalRepository.findById(id);

    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun addDetails(@RequestBody personalDetails: PersonalDetails) :Mono<PersonalDetails>{
        studentProducer.registerDetails(personalDetails)
        return personalRepository.save(personalDetails)
    }

    @PutMapping("/{id}")
    fun updateDetails(@PathVariable id: String, @RequestBody personalDetails: PersonalDetails) : Mono<PersonalDetails>{
        return personalRepository.save(personalDetails)

    }

    @DeleteMapping("/{id}")
    fun deleteDetails(@PathVariable id: String) : Mono<Void>{
        return personalRepository.deleteById(id);
    }


}