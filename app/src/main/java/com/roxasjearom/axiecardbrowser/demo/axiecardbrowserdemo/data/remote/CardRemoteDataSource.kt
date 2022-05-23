package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote.response.OriginData

class CardRemoteDataSource(
    private val originApi: OriginApi,
) {
    suspend fun getOriginData(): OriginData {
        return originApi.getOriginData()
    }
}
