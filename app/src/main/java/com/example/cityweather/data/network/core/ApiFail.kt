package com.example.cityweather.data.network.core

import retrofit2.HttpException
import rx.functions.Action1
import java.io.IOException
import java.lang.Exception


abstract class ApiFail : Action1<Throwable> {

    override fun call(t: Throwable?) {
        try{
            if(t is HttpException){
                val http = t
                val response =
                    HttpErrorResponse(
                        http.code(),
                        http.response()
                    )
                response.error = http.message()
                httpStatus(response)
            }else if(t is IOException){
                noNetwork()
            } else {
                if(t != null){
                    unknownError(t)
                }
            }
        }catch (e : Exception){
            unknownError(e)
        }
    }

    abstract fun httpStatus(response: HttpErrorResponse)

    abstract fun noNetwork()

    abstract fun unknownError(e:Throwable)
}