package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.entity.OriginCardEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CardLocalDataSource @Inject constructor(
    private val appDatabase: AppDatabase,
) {
    suspend fun saveCards(cardEntities: List<OriginCardEntity>) {
        appDatabase.originCardDao().insertCards(cardEntities)
    }

    fun getCards(): Flow<List<OriginCardEntity>> {
        return appDatabase.originCardDao().getCards()
    }
}
