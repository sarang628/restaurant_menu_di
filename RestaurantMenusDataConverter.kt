package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.data.remote.response.MenuApiModel
import com.sarang.torang.data.remote.response.RestaurantDetailApiModel


fun RestaurantDetailApiModel.toMenus(): List<Menu> {
    return this.menus.map {
        Menu.Item(MenuData(
            menuName = it.menuName ?: "",
            price = "${it.menuPrice}",
            url = BuildConfig.MENU_IMAGE_SERVER_URL + it.menuPicUrl
            )
        )
    }
}

fun MenuApiModel.toMenu() : Menu{
    if(this.parentId == null)
        return Menu.Category(this.menuName ?: "")
    return Menu.Item(
        MenuData(
            menuName = this.menuName ?: "",
            price = this.menuPrice.toString(),
            url = BuildConfig.MENU_IMAGE_SERVER_URL + this.menuPicUrl
        )
    )
}

fun MenuApiModel.toMenuData() : MenuData{
    return MenuData(
        menuName = this.menuName ?: "",
        price = this.menuPrice.toString(),
        url = BuildConfig.MENU_IMAGE_SERVER_URL + this.menuPicUrl
    )
}