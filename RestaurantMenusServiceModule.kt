package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.api.ApiMenu
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.usecase.GetMenuUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RestaurantMenusServiceModule {

    @Provides
    fun providesGetMenuUseCase(apiMenu: ApiMenu): GetMenuUseCase {
        return object : GetMenuUseCase {
            override suspend fun invoke(restaurantId: Int): List<Menu> {
                return apiMenu.findByRestaurantId(restaurantId).map {
                    it.toMenu()
                }
            }
        }
    }
}