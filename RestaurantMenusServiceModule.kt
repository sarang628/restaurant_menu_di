package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.api.ApiMenu
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.data.remote.response.MenuApiModel
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

                val result : List<MenuApiModel> = apiMenu.findByRestaurantId(restaurantId)

                val menus : List<Menu> = result.flatMap { parent ->
                    listOf(parent.toMenu()) +                                       // 카테고리 +
                            (parent.children?.chunked(2)?.map {              // 2개 묶음
                                val first = it[0].toMenuData()                      // 첫번째는 무조건 데이터 있음
                                val second = it.getOrNull(1)?.toMenuData()  // 두번째는 없을 수도 있음
                                second?.let { Menu.PairItem(Pair(first,it)) }
                                        ?:  Menu.Item(first)
                            } ?: emptyList())
                }

                return menus
            }
        }
    }
}