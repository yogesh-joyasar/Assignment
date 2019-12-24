package com.example.cityweather.data.network.core

import rx.functions.Action1

abstract class ApiSuccess<T> : Action1<T> {
}