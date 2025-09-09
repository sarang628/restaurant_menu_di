package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.compose.menu.RestaurantMenuPullToRefresh
import com.sarang.torang.di.pulltorefresh.providePullToRefresh
import com.sryang.library.pullrefresh.rememberPullToRefreshState

val CustomRestaurantMenuPullToRefresh : RestaurantMenuPullToRefresh = {a,b,c,d -> providePullToRefresh(rememberPullToRefreshState()).invoke(a,b,c,d) }