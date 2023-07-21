package com.example.finalcompose.ui.navigation

sealed class Screen(val route: String){
    object Collection : Screen("collection")
    object CollectionDetail : Screen("collection/{collectionId}/{type}") {
        fun createRoute(collectionId: String, type: String) = "collection/$collectionId/$type"
    }
    object Profile : Screen("profile")
}
