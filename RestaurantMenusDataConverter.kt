package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.compose.menu.MenuData
import com.sarang.torang.data.RestaurantDetail
import com.sarang.torang.data.remote.response.RestaurantDetailApiModel


fun RestaurantDetailApiModel.toMenus(): List<MenuData> {
    return this.menus.map {
        MenuData(
            menuName = it.menu_name ?: "",
            price = it.menu_price?.toFloat() ?: 0f,
            url = BuildConfig.MENU_IMAGE_SERVER_URL + it.menu_pic_url
        )
    }
}
