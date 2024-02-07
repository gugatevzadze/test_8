package com.example.test_8.presentation.screen.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_8.data.remote.common.Resource
import com.example.test_8.domain.usecase.GetItemUseCase
import com.example.test_8.presentation.event.item.ItemEvents
import com.example.test_8.presentation.mapper.item.toPresentation
import com.example.test_8.presentation.state.item.ItemState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase
) : ViewModel() {

    private val _itemState = MutableStateFlow(ItemState())
    val itemState: SharedFlow<ItemState> get()= _itemState

    fun onEvent(event: ItemEvents) {
        when (event) {
            is ItemEvents.GetItems -> getItems()
            is ItemEvents.UpdateErrorMessages -> updateErrorMessages(message = null)
        }
    }

    private fun getItems() {
        viewModelScope.launch {
            handleResource(getItemUseCase.invoke()) { data ->
                _itemState.update { currentState ->
                    currentState.copy(items = data.map { it.toPresentation() })
                }
            }
        }
    }

    private fun updateErrorMessages(message: String?) {
        _itemState.update { currentState ->
            currentState.copy(
                errorMessage = message
            )
        }
    }

    private fun <T> handleResource(resourceFlow: Flow<Resource<T>>, handleSuccess: (T) -> Unit) {
        viewModelScope.launch {
            resourceFlow.collect { resource ->
                when (resource) {
                    is Resource.Success -> handleSuccess(resource.data)
                    is Resource.Error -> updateErrorMessages(resource.errorMessage)
                    is Resource.Loading -> _itemState.update { currentState ->
                        currentState.copy(isLoading = resource.loading)
                    }
                }
            }
        }
    }
}