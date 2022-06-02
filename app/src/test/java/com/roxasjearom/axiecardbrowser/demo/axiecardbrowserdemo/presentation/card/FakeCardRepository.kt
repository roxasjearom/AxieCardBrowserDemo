package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.presentation.card

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.OriginCard
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCardRepository : CardRepository {
    override suspend fun fetchData() {
        //Do nothing here
    }

    override suspend fun getCards(): Flow<List<OriginCard>> {
        return flow { emit(fakeCardData) }
    }
}
