package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote.response.OriginData
import javax.inject.Inject

class CardRemoteDataSource @Inject constructor(
    private val originApi: OriginApi,
) {
    suspend fun getOriginData(): OriginData {
        return originApi.getOriginData()
    }
}
