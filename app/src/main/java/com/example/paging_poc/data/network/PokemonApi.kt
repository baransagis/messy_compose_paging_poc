package com.example.paging_poc.data.network


import com.example.paging_poc.data.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("v2/pokemon/")
    suspend fun getPokemon(
        @Query("offset") offset: Int  // a page contains 20 items, new pages can be retrieved with offset
    ): Response<PokemonResponse>

}