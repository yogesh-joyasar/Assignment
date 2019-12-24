package com.example.cityweather.data.network.core

import retrofit2.Response

class HttpErrorResponse(code: Int, response: Response<*>?) {

    var error : String? = null
}