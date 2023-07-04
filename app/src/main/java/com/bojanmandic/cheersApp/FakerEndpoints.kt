package com.bojanmandic.cheersApp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FakerEndpoints {
    @GET("api/json/v1/1/search.php?")
    fun getCocktail(@Query("s") s: String): Call<CocktailList>

    @GET("/api/json/v1/1/random.php")
    fun getRandom() :Call<CocktailList>

}