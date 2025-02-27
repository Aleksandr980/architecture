package com.example.m16_architecture.domain

import com.example.m16_architecture.data.UsefulActivityRepository
import com.example.m16_architecture.entity.UsefulActivity
import javax.inject.Inject


class GetUsefulActivityUseCase @Inject constructor(private val usefulActivityRepository: UsefulActivityRepository) {
    suspend fun execute(): UsefulActivity {
        val getExecute = usefulActivityRepository.getNewActivity()
        return getExecute
    }
}




