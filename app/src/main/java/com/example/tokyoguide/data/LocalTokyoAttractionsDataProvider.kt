package com.example.tokyoguide.data

import com.example.tokyoguide.R
import com.example.tokyoguide.model.AttractionCategory
import com.example.tokyoguide.model.Place

object LocalTokyoAttractionsDataProvider {

  val allAttractions = listOf(
        // ================= CULTURAL & HISTORICAL (1–4) =================
        Place(
            id = 1,
            title = R.string.title_sensoji_temple,
            address = R.string.address_sensoji_temple,
            hours = R.string.hours_sensoji_temple,
            description = R.string.description_sensoji_temple,
            imageResourceId = R.drawable.sensoji_temple, // Placeholder drawable
            category = AttractionCategory.CULTURAL_HISTORICAL
        ),
        Place(
            id = 2,
            title = R.string.title_meiji_shrine,
            address = R.string.address_meiji_shrine,
            hours = R.string.hours_meiji_shrine,
            description = R.string.description_meiji_shrine,
            imageResourceId = R.drawable.meiji_shrine,
            category = AttractionCategory.CULTURAL_HISTORICAL
        ),
        Place(
            id = 3,
            title = R.string.title_edo_tokyo_museum,
            address = R.string.address_edo_tokyo_museum,
            hours = R.string.hours_edo_tokyo_museum,
            description = R.string.description_edo_tokyo_museum,
            imageResourceId = R.drawable.edo_tokyo_museum,
            category = AttractionCategory.CULTURAL_HISTORICAL
        ),
        Place(
            id = 4,
            title = R.string.title_imperial_palace,
            address = R.string.address_imperial_palace,
            hours = R.string.hours_imperial_palace,
            description = R.string.description_imperial_palace,
            imageResourceId = R.drawable.imperial_palace,
            category = AttractionCategory.CULTURAL_HISTORICAL
        ),

        // ================= SHOPPING & POP CULTURE (5–8) =================
        Place(
            id = 5,
            title = R.string.title_shibuya_crossing,
            address = R.string.address_shibuya_crossing,
            hours = R.string.hours_shibuya_crossing,
            description = R.string.description_shibuya_crossing,
            imageResourceId = R.drawable.shibuya_crossing,
            category = AttractionCategory.SHOPPING_POP_CULTURE
        ),
        Place(
            id = 6,
            title = R.string.title_takeshita_street,
            address = R.string.address_takeshita_street,
            hours = R.string.hours_takeshita_street,
            description = R.string.description_takeshita_street,
            imageResourceId = R.drawable.takeshita_street,
            category = AttractionCategory.SHOPPING_POP_CULTURE
        ),
        Place(
            id = 7,
            title = R.string.title_ginza,
            address = R.string.address_ginza,
            hours = R.string.hours_ginza,
            description = R.string.description_ginza,
            imageResourceId = R.drawable.ginza_shopping_district,
            category = AttractionCategory.SHOPPING_POP_CULTURE
        ),
        Place(
            id = 8,
            title = R.string.title_nakano_broadway,
            address = R.string.address_nakano_broadway,
            hours = R.string.hours_nakano_broadway,
            description = R.string.description_nakano_broadway,
            imageResourceId = R.drawable.nakano_broadway,
            category = AttractionCategory.SHOPPING_POP_CULTURE
        ),

        // ================= TECH & FUTURISTIC (9–12) =================
        Place(
            id = 9,
            title = R.string.title_akihabara,
            address = R.string.address_akihabara,
            hours = R.string.hours_akihabara,
            description = R.string.description_akihabara,
            imageResourceId = R.drawable.akihabara,
            category = AttractionCategory.TECH_FUTURISTIC
        ),
        Place(
            id = 10,
            title = R.string.title_odaiba,
            address = R.string.address_odaiba,
            hours = R.string.hours_odaiba,
            description = R.string.description_odaiba,
            imageResourceId = R.drawable.odaiba,
            category = AttractionCategory.TECH_FUTURISTIC
        ),
        Place(
            id = 11,
            title = R.string.title_robot_restaurant,
            address = R.string.address_robot_restaurant,
            hours = R.string.hours_robot_restaurant,
            description = R.string.description_robot_restaurant,
            imageResourceId = R.drawable.robot_restaurant,
            category = AttractionCategory.TECH_FUTURISTIC
        ),
        Place(
            id = 12,
            title = R.string.title_teamlab_planets,
            address = R.string.address_teamlab_planets,
            hours = R.string.hours_teamlab_planets,
            description = R.string.description_teamlab_planets,
            imageResourceId = R.drawable.teamlab_planets,
            category = AttractionCategory.TECH_FUTURISTIC
        ),

        // ================= FOOD & CULINARY (13–16) =================
        Place(
            id = 13,
            title = R.string.title_tsukiji_outer_market,
            address = R.string.address_tsukiji_outer_market,
            hours = R.string.hours_tsukiji_outer_market,
            description = R.string.description_tsukiji_outer_market,
            imageResourceId = R.drawable.tsukiji_outer_market,
            category = AttractionCategory.FOOD_CULINARY
        ),
        Place(
            id = 14,
            title = R.string.title_ramen_street,
            address = R.string.address_ramen_street,
            hours = R.string.hours_ramen_street,
            description = R.string.description_ramen_street,
            imageResourceId = R.drawable.ramen_street,
            category = AttractionCategory.FOOD_CULINARY
        ),
        Place(
            id = 15,
            title = R.string.title_pompompurin_cafe,
            address = R.string.address_pompompurin_cafe,
            hours = R.string.hours_pompompurin_cafe,
            description = R.string.description_pompompurin_cafe,
            imageResourceId = R.drawable.pompompurin_cafe, // Placeholder
            category = AttractionCategory.FOOD_CULINARY
        ),
        Place(
            id = 16,
            title = R.string.title_animal_cafes,
            address = R.string.address_animal_cafes,
            hours = R.string.hours_animal_cafes,
            description = R.string.description_animal_cafes,
            imageResourceId = R.drawable.animal_cafes,
            category = AttractionCategory.FOOD_CULINARY
        ),

        // ================= SCENIC & RELAXATION (17–20) =================
        Place(
            id = 17,
            title = R.string.title_mount_takao,
            address = R.string.address_mount_takao,
            hours = R.string.hours_mount_takao,
            description = R.string.description_mount_takao,
            imageResourceId = R.drawable.mount_takao,
            category = AttractionCategory.SCENIC_RELAXATION
        ),
        Place(
            id = 18,
            title = R.string.title_yoyogi_park,
            address = R.string.address_yoyogi_park,
            hours = R.string.hours_yoyogi_park,
            description = R.string.description_yoyogi_park,
            imageResourceId = R.drawable.yoyogi_park,
            category = AttractionCategory.SCENIC_RELAXATION
        ),
        Place(
            id = 19,
            title = R.string.title_tokyo_skytree,
            address = R.string.address_tokyo_skytree,
            hours = R.string.hours_tokyo_skytree,
            description = R.string.description_tokyo_skytree,
            imageResourceId = R.drawable.tokyo_skytree,
            category = AttractionCategory.SCENIC_RELAXATION
        ),
        Place(
            id = 20,
            title = R.string.title_roppongi_hills,
            address = R.string.address_roppongi_hills,
            hours = R.string.hours_roppongi_hills,
            description = R.string.description_roppongi_hills,
            imageResourceId = R.drawable.roppongi_hills,
            category = AttractionCategory.SCENIC_RELAXATION
        )
    )

//    // For convenience, you can expose the whole list or just a default place:
//    fun getAllAttractions(): List<Place> = attractions
//    val defaultAttraction: Place get() = attractions.first()
}