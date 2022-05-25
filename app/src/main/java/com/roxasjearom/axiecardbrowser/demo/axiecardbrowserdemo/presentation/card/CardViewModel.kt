package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.presentation.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.model.OriginCard
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val cardRepository: CardRepository,
) : ViewModel() {

    private var completeCards = emptyList<OriginCard>()

    private val _cardsUiState = MutableStateFlow(CardsUiState())
    val cardsUiState: StateFlow<CardsUiState> = _cardsUiState.stateIn(
        initialValue = CardsUiState(),
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000)
    )

    init {
        fetchOriginData()
        getCards()
    }

    private fun fetchOriginData() {
        viewModelScope.launch {
            try {
                _cardsUiState.update { uiState ->
                    uiState.copy(isLoading = true)
                }
                cardRepository.fetchData()
                _cardsUiState.update { uiState ->
                    uiState.copy(isLoading = false)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _cardsUiState.update { uiState ->
                    uiState.copy(
                        isLoading = false,
                        message = "Fetching data failed"
                    )
                }
            }
        }
    }

    private fun getCards() {
        viewModelScope.launch {
            cardRepository.getCards().collect { cards ->
                completeCards = cards
                _cardsUiState.update { uiState ->
                    uiState.copy(
                        cards = cards
                    )
                }
            }
        }
    }

    fun messageShown() {
        _cardsUiState.update { uiState ->
            uiState.copy(message = null)
        }
    }
}

data class CardsUiState(
    val cards: List<OriginCard> = emptyList(),
    val isLoading: Boolean = false,
    val hasFilter: Boolean = false,
    val message: String? = null,
)
