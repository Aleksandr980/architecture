package com.example.m16_architecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m16_architecture.data.UsefulActivityDto
import com.example.m16_architecture.domain.GetUsefulActivityUseCase
import com.example.m16_architecture.entity.UsefulActivity
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUsefulActivityUseCase: GetUsefulActivityUseCase) :
    ViewModel() {

    private val _stateFlow: MutableStateFlow<UsefulActivity> =
        MutableStateFlow(UsefulActivityDto(""))
    val stateFlow = _stateFlow.asStateFlow()

//    init {
//        reloadUsefulActivity()
//    }

    fun reloadUsefulActivity() {
        viewModelScope.launch {
            val result = getUsefulActivityUseCase.execute()
            _stateFlow.emit(result)
        }
    }
}

