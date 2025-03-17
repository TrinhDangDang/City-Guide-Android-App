package com.example.tokyoguide.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tokyoguide.R
import com.example.tokyoguide.model.AttractionCategory
import com.example.tokyoguide.model.Place
import com.example.tokyoguide.ui.theme.TokyoGuideTheme

enum class TokyoGuideAppScreens{
    CATEGORY_SCREEN,
    ATTRACTIONS_SCREEN,
    DETAILS_SCREEN
}
@Composable
fun TokyoGuideApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
){
    val viewModel: TokyoGuideViewModel = viewModel()
    val tokyoGuideUiState = viewModel.uiState.collectAsState().value

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TokyoGuideAppScreens.valueOf(
        backStackEntry?.destination?.route ?: TokyoGuideAppScreens.CATEGORY_SCREEN.name
    )

    Scaffold (
        topBar = {
            TokyoGuideAppBar(
                tokyoGuideUiState = tokyoGuideUiState,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateBack = {navController.navigateUp()}
                )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TokyoGuideAppScreens.CATEGORY_SCREEN.name,
            modifier = Modifier
                .padding(innerPadding),
        ) {
            composable(route = TokyoGuideAppScreens.CATEGORY_SCREEN.name) {
                ListScreen(
                    currentScreen = currentScreen.name,
                    tokyoGuideUiState = tokyoGuideUiState,
                    onCategorySelected = { category ->
                        viewModel.updateCurrentCategory(category)
                        navController.navigate(TokyoGuideAppScreens.ATTRACTIONS_SCREEN.name)
                    },
                    onAttractionSelected = { selectedAttraction ->
                        viewModel.updateCurrentAttraction(
                            selectedAttraction
                        )
                    }
                )
            }
            composable(route = TokyoGuideAppScreens.ATTRACTIONS_SCREEN.name) {
                ListScreen(
                    currentScreen = currentScreen.name,
                    tokyoGuideUiState = tokyoGuideUiState,
                    onCategorySelected = { category -> viewModel.updateCurrentCategory(category) },
                    onAttractionSelected = { selectedAttraction ->
                        viewModel.updateCurrentAttraction(
                            selectedAttraction
                        )
                        navController.navigate(TokyoGuideAppScreens.DETAILS_SCREEN.name)
                    }
                )
            }
            composable(route = TokyoGuideAppScreens.DETAILS_SCREEN.name) {
                DetailsScreen(
                    tokyoGuideUiState = tokyoGuideUiState
                )
            }
        }
    }

}

@Composable
fun DetailsScreen(
    tokyoGuideUiState: TokyoGuideUiState,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(tokyoGuideUiState.currentAttraction.imageResourceId),
                contentDescription = stringResource(tokyoGuideUiState.currentAttraction.title),
                modifier = Modifier
                    .size(350.dp),
                contentScale = ContentScale.FillWidth
            )

                Text(text = stringResource(tokyoGuideUiState.currentAttraction.description))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = "address: ${stringResource(tokyoGuideUiState.currentAttraction.address)}")
                        Text(text = "hours: ${stringResource(tokyoGuideUiState.currentAttraction.hours)}")
                    }

                }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TokyoGuideAppBar(
    tokyoGuideUiState: TokyoGuideUiState,
    currentScreen: TokyoGuideAppScreens,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(

        title = { Text(
            text = when (currentScreen){
                TokyoGuideAppScreens.CATEGORY_SCREEN -> "LET'S EXPLORE TOKYO"
                TokyoGuideAppScreens.DETAILS_SCREEN -> stringResource(tokyoGuideUiState.currentAttraction.title)
                TokyoGuideAppScreens.ATTRACTIONS_SCREEN -> tokyoGuideUiState.currentCategory.name
                else -> "Tokyo Guide"
            },
            modifier = Modifier.fillMaxWidth()
        ) },
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = {navigateBack()}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        },
        modifier = modifier

    )
}

@Composable
fun ListScreen(
    currentScreen: String,
    tokyoGuideUiState: TokyoGuideUiState,
    onCategorySelected: (AttractionCategory) -> Unit,
    onAttractionSelected: (Place) -> Unit,
    modifier: Modifier = Modifier
){

 val listToDisplay  = when (currentScreen) {
     TokyoGuideAppScreens.CATEGORY_SCREEN.name -> tokyoGuideUiState.attractions.keys.toList() // Show all categories
     TokyoGuideAppScreens.ATTRACTIONS_SCREEN.name -> tokyoGuideUiState.currentCategoryAttractions
     else -> listOf("tokyo", "guide", "app")
 }

        LazyColumn(
            modifier = modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),

        ) {
            items(listToDisplay) { item ->
                when (item) {
                    is AttractionCategory -> ListItem(
                        categoryName = item,
                        onSelected = { onCategorySelected(item) }
                    )
                    is Place -> ListItem(
                        attraction = item,
                        onSelected = { onAttractionSelected(item) }
                    )
                }
            }
    }


}

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    attraction: Place? = null,
    categoryName: AttractionCategory? = null,
    onSelected: () -> Unit,
){
    Card (
        modifier = modifier
            .clickable { onSelected() }
        ) {
        Row {
            if (attraction != null) {
                Image(
                    painter = painterResource(attraction.imageResourceId),
                    contentDescription = stringResource(attraction.title),
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.card_image_height)),
                    contentScale = ContentScale.Crop
                )
            } else {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.card_image_height)))
            }
            Text(
                text = categoryName?.name ?: stringResource(attraction!!.title),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)

            )
        }
    }
}


@Preview
@Composable
fun ListItemPreview(){
    TokyoGuideTheme {
        ListItem(
            attraction = Place(
                title = R.string.title_ginza,
                imageResourceId = R.drawable.ginza_shopping_district,
                id = 1,
                description = R.string.description_ginza,
                address = R.string.address_ginza,
                hours = R.string.hours_ginza,
                category = AttractionCategory.CULTURAL_HISTORICAL
            ),
            categoryName = AttractionCategory.CULTURAL_HISTORICAL,
            onSelected = {}
        )
    }
}

@Preview
@Composable
fun TokyoGuideAppPreview(){
    TokyoGuideTheme {
        TokyoGuideApp(WindowWidthSizeClass.Compact)
    }
}

@Preview
@Composable
fun DetailsScreenPreview(){
    TokyoGuideTheme {
        DetailsScreen(
            tokyoGuideUiState = TokyoGuideUiState()
        )
    }
}



