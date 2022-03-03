package com.app.observablestudy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StudyViewModel : ViewModel() {

    private val mLivedata = MutableLiveData<String>()
    val _Livedata: LiveData<String> = mLivedata

    private val _stateFlow = MutableStateFlow("text")
    val stateFlow: StateFlow<String> = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun triggerLiveData() {

        mLivedata.postValue("live data")

    }


    fun triggerStateFlow() {
        viewModelScope.launch {
            _stateFlow.value = "state flow"
        }
    }

    fun triggerSharedFlow() {
        viewModelScope.launch {
            _sharedFlow.emit("shared flow")
        }
    }


    fun triggerFlow(): Flow<String> {
        return flow<String> {
            repeat(5) {
                emit("item $it")
                delay(1000)
            }
        }
    }


}