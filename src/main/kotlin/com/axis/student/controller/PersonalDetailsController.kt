package com.axis.student.controller

import com.axis.student.entity.PersonalDetails
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
    val personalRepository: PersonalDetailsRepository

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
        return personalRepository.save(personalDetails)
    }


}