package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote.response.OriginData
import retrofit2.http.GET

interface OriginApi {
    @GET("/api/origin-test-data.json")
    suspend fun getOriginCards(): OriginData
}
