package com.axis.student.repo

import com.axis.student.entity.PersonalDetails
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PersonalDetailsRepository: ReactiveCrudRepository<PersonalDetails, String> {

}