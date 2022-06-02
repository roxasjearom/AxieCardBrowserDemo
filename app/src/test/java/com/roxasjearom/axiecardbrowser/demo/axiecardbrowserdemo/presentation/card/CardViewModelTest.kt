package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.presentation.card

import com.google.common.truth.Truth.assertThat
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.CardClass
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.CardClassFilter
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.PartType
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.PartTypeFilter
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.presentation.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CardViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var cardViewModel: CardViewModel

    @Before
    fun setup() {
        cardViewModel = CardViewModel(FakeCardRepository())
    }

    @Test
    fun `Should filter correctly with a filter`() = runTest {
        cardViewModel.filterCards(CardClassFilter("beast", CardClass.BEAST))

        val actualState = cardViewModel.cardsUiState.first()
        //FakeCardData has 1 Beast card
        assertThat(actualState.cards.size).isEqualTo(1)
        assertThat(actualState.hasFilter).isTrue()
    }

    @Test
    fun `Should filter correctly with multiple filter`() = runTest {
        cardViewModel.filterCards(CardClassFilter("bird", CardClass.BIRD))
        cardViewModel.filterCards(PartTypeFilter("back", PartType.BACK))

        val actualState = cardViewModel.cardsUiState.first()
        //FakeCardData has 1 Bird card with back part
        assertThat(actualState.cards.size).isEqualTo(1)
        assertThat(actualState.hasFilter).isTrue()
    }

    @Test
    fun `Should clear message upon calling messageShown`() = runTest {
        cardViewModel.messageShown()

        val actualState = cardViewModel.cardsUiState.first()
        assertThat(actualState.message).isNull()
    }

    @Test
    fun `Should clear filters upon calling clearFilters`() = runTest {
        cardViewModel.clearFilters()

        val actualState = cardViewModel.cardsUiState.first()
        assertThat(actualState.hasFilter).isFalse()
    }
}
