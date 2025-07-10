package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.compose.menu.MenuData
import com.sarang.torang.data.RestaurantDetail


fun RestaurantDetail.toMenus(): List<MenuData> {
    return this.menus.map {
        MenuData(
            menuName = it.menu_name,
            price = it.menu_price.toFloat(),
            url = BuildConfig.MENU_IMAGE_SERVER_URL + it.menu_pic_url
        )
    }
}
