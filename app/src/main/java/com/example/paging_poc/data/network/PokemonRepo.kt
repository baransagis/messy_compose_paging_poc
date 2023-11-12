package com.example.paging_poc.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig


class PokemonRepo(
  private val pokemonApi: PokemonApi
) {
    fun getPokemon() = Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = {
                PokemonPagingSource(pokemonApi = pokemonApi)
            }
        ).flow
    }
