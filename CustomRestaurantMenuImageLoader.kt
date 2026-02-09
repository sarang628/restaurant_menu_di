package com.sarang.torang.di.restaurant_menu_di

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sarang.torang.compose.menu.RestaurantMenuImageLoader
import com.sarang.torang.di.image.TorangAsyncImageData
import com.sarang.torang.di.image.provideTorangAsyncImage

val customRestaurantMenuImageLoader : RestaurantMenuImageLoader = {
    modifier, url, progressSize, errorIconSize, contentScale ->
    provideTorangAsyncImage().invoke(
        TorangAsyncImageData(
            modifier = modifier,
            model = url,
            progressSize = progressSize ?: 30.dp,
            errorIconSize = errorIconSize ?: 30.dp,
            contentScale = contentScale ?: ContentScale.None
        )
    )
}