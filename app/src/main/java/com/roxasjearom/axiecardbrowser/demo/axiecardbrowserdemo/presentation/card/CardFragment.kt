package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.presentation.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.databinding.FragmentCardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CardFragment : Fragment() {

    private val viewModel: CardViewModel by viewModels()

    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var cardAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardListRecyclerView.apply {
            this.adapter = cardAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        setObserver()
    }

    private fun setObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.cardsUiState.collect { uiState ->
                        cardAdapter.setCards(uiState.cards)

                        binding.noResultImage.visibility =
                            if (uiState.cards.isEmpty()) View.VISIBLE else View.GONE

                        binding.bottomSheetFilters.clearButton.visibility =
                            if (uiState.hasFilter) View.VISIBLE else View.INVISIBLE

                        binding.progressIndicator.visibility =
                            if (uiState.isLoading) View.VISIBLE else View.GONE

                        uiState.message?.let { message ->
                            Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
                            viewModel.messageShown()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
