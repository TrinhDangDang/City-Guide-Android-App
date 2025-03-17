package com.example.tokyoguide.ui

import androidx.lifecycle.ViewModel
import com.example.tokyoguide.data.LocalTokyoAttractionsDataProvider
import com.example.tokyoguide.model.AttractionCategory
import com.example.tokyoguide.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TokyoGuideViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(TokyoGuideUiState())
    val uiState: StateFlow<TokyoGuideUiState> = _uiState


    init {
        initializeTokyoGuideUiState()
    }

    private fun initializeTokyoGuideUiState(){
        val attractions: Map<AttractionCategory, List<Place>> = LocalTokyoAttractionsDataProvider.allAttractions.groupBy { it.category }
        _uiState.update {
            it.copy(
                attractions = attractions,
            )
        }
    }

    fun updateCurrentCategory(category: AttractionCategory){
        _uiState.update {
            it.copy(
                currentCategory = category,
                isCategoriesScreen = false,
                isAttractionsScreen = true,

                  // LocalTokyoAttractionsDataProvider.allAttractions.filter { it.category == category }

            )
        }
    }

    fun updateCurrentAttraction(attraction: Place){
        _uiState.update {
            it.copy(
                currentAttraction = attraction,
                isAttractionsScreen = false,
            )
        }
    }



}

data class TokyoGuideUiState(
    val attractions: Map<AttractionCategory, List<Place>> = emptyMap(),
    val currentAttraction: Place = LocalTokyoAttractionsDataProvider.allAttractions[0],
    val currentCategory: AttractionCategory = AttractionCategory.CULTURAL_HISTORICAL,
    val isCategoriesScreen: Boolean = true,
    val isAttractionsScreen:Boolean = false,

){
    val currentCategoryAttractions: List<Place> by lazy {attractions[currentCategory]!!}
}