package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.data.remote.response.RestaurantDetailApiModel


fun RestaurantDetailApiModel.toMenus(): List<Menu> {
    return this.menus.map {
        Menu.Item(
            menuName = it.menu_name ?: "",
            price = "${it.menu_price}",
            url = BuildConfig.MENU_IMAGE_SERVER_URL + it.menu_pic_url
        )
    }
}
