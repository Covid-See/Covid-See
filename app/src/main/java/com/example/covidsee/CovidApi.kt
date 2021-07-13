package com.example.covidsee

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class CovidApi {
    companion object {
        val DOMAIN = "https://api.corona-19.kr"
        val TOKEN = "EDdKRf7gXjQCOyi9mpH85uFrZlbWTzkAe"
    }
}

interface CovidService {
    @GET("/korea/country/new/")
    fun getDocument(@Query("serviceKey") serviceKey: String): Call<RegionVO>
}