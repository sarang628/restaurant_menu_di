package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.compose.menu.RestaurantMenuImageLoader
import com.sarang.torang.di.image.provideTorangAsyncImage

val customLocalRestaurantMenuImageLoader : RestaurantMenuImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}