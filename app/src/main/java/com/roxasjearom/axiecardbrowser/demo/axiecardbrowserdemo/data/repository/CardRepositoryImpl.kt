package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.repository

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.CardLocalDataSource
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.mapper.toEntity
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.mapper.toOriginCard
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.remote.CardRemoteDataSource
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.OriginCard
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val remoteDataSource: CardRemoteDataSource,
    private val localDataSource: CardLocalDataSource,
) : CardRepository {

    override suspend fun fetchData() {
        val cards = remoteDataSource.getOriginData().cards.map { it.toEntity() }
        localDataSource.saveCards(cards)
    }

    override suspend fun getCards(): Flow<List<OriginCard>> {
        return localDataSource.getCards().distinctUntilChanged().map { cards ->
            cards.map { it.toOriginCard() }
        }
    }
}
