package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.compose.menu.RestaurantMenuImageLoader
import com.sarang.torang.di.image.provideTorangAsyncImage

val customRestaurantMenuImageLoader : RestaurantMenuImageLoader = provideTorangAsyncImage()