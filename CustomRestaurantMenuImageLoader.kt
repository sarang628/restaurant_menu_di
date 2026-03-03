package com.sarang.torang.di.restaurant_menu_di

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sarang.torang.compose.component.menu.RestaurantMenuImageLoader
import com.sarang.torang.di.image.TorangAsyncImageData
import com.sarang.torang.di.image.provideTorangAsyncImage

val customRestaurantMenuImageLoader : RestaurantMenuImageLoader = {
    provideTorangAsyncImage().invoke(
        TorangAsyncImageData(
            modifier        = it.modifier,
            model           = it.url,
            progressSize    = it.progressSize ?: 30.dp,
            errorIconSize   = it.errorIconSize ?: 30.dp,
            contentScale    = it.contentScale ?: ContentScale.None
        )
    )
}