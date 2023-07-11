package com.axis.student.repo

import com.axis.student.entity.PersonalDetails
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

import org.springframework.stereotype.Repository


@Repository
interface PersonalDetailsRepository: ReactiveMongoRepository<PersonalDetails, String> {

}