package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.compose.component.menu.RestaurantMenuPullToRefresh
import com.sarang.torang.di.pulltorefresh.PullToRefreshData
import com.sarang.torang.di.pulltorefresh.providePullToRefresh
import com.sryang.library.pullrefresh.RefreshIndicatorState
import com.sryang.library.pullrefresh.rememberPullToRefreshState

val CustomRestaurantMenuPullToRefresh : RestaurantMenuPullToRefresh = { providePullToRefresh(rememberPullToRefreshState()).invoke(
    PullToRefreshData(it.modifier, RefreshIndicatorState.Default, it.onRefresh, it.contents)
) }