package com.example.paging_poc.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging_poc.data.model.Pokemon

private const val OFFSET = 20

class PokemonPagingSource(private val pokemonApi: PokemonApi) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val offset = (params.key ?: 0) * OFFSET
            val data = pokemonApi.getPokemon(offset = offset).body()?.results ?: emptyList()

            LoadResult.Page(
                data = data,
                prevKey = params.key?.minus(1),
                nextKey = if (data.isEmpty()) null else params.key?.plus(1) ?: 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}