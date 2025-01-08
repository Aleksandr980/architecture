package com.example.m16_architecture.data

import com.example.m16_architecture.entity.UsefulActivity
import javax.inject.Inject


class UsefulActivityRepository @Inject constructor(private val api: Api) {
    suspend fun getNewActivity(): UsefulActivity {
        return api.getNewActivity()
    }
}




