package com.axis.student.repo

import com.axis.student.entity.CollegeDetails
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CollegeDetailsRepository:ReactiveMongoRepository<CollegeDetails,String> {


}