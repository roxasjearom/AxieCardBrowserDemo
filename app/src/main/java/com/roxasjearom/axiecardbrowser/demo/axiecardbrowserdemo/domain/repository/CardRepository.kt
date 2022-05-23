package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.repository

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.OriginCard
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun fetchData()
    suspend fun getCards(): Flow<List<OriginCard>>
}
