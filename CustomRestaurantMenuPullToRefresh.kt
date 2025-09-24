package com.sarang.torang.di.restaurant_menu_di

import com.sarang.torang.compose.menu.RestaurantMenuPullToRefresh
import com.sarang.torang.di.pulltorefresh.PullToRefreshData
import com.sarang.torang.di.pulltorefresh.providePullToRefresh
import com.sryang.library.pullrefresh.RefreshIndicatorState
import com.sryang.library.pullrefresh.rememberPullToRefreshState

val CustomRestaurantMenuPullToRefresh : RestaurantMenuPullToRefresh = {modifier, isRefreshing, onRefresh, contents -> providePullToRefresh(rememberPullToRefreshState()).invoke(
    PullToRefreshData(modifier, com.sarang.torang.compose.feed.state.RefreshIndicatorState.Default  ,onRefresh ,contents)
) }