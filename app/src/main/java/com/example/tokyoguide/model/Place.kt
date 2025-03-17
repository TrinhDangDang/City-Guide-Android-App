package com.example.tokyoguide.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val address: Int,
    @StringRes val hours: Int,
    @StringRes val description: Int,
    @DrawableRes val imageResourceId: Int,
    val category: AttractionCategory
    // Optional: Add val priceRange: String = "" if you want cost info
)