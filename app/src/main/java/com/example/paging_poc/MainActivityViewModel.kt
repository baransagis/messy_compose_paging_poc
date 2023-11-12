package com.example.paging_poc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging_poc.data.model.Pokemon
import com.example.paging_poc.data.network.PokemonRepo
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainActivityViewModel(get()) }
}
class MainActivityViewModel(
    private val repository: PokemonRepo,
): ViewModel() {
    fun getPokemon(): Flow<PagingData<Pokemon>> = repository.getPokemon().cachedIn(viewModelScope)
}