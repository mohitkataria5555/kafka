package com.axis.student.controller

import com.axis.student.entity.CollegeDetails


import com.axis.student.repo.CollegeDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/college")
class CollegeDetailsController (

    @Autowired
    val collegeDetailsRepository: CollegeDetailsRepository
    )


{

    @GetMapping("/")
    fun getCollegeDetails(): Flux<CollegeDetails> {
        return collegeDetailsRepository.findAll();
    }

        @PostMapping("/add")
        @ResponseStatus(HttpStatus.CREATED)
        fun addCollege(@RequestBody collegeDetails: CollegeDetails) :Mono<CollegeDetails>{
            return collegeDetailsRepository.save(collegeDetails);

        }

    @GetMapping("/{id}")
    fun getCollegeById(@PathVariable id:String):Mono<CollegeDetails>{
        return collegeDetailsRepository.findById(id);
    }







}

