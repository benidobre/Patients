package com.example.patients

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object WebAccess {
    val partsApi : PartsApiClient by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://alexgr.ro/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        // Create Retrofit client
        return@lazy retrofit.create(PartsApiClient::class.java)
    }
}

interface PartsApiClient {
    @GET("ehealth/patients.json")
    suspend fun getPatients(): List<Patients>
}