package dev.eighteentech.tala

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.eighteentech.tala.entities.Item
import dev.eighteentech.tala.entities.Response
import dev.eighteentech.tala.entities.Response.Loading
import dev.eighteentech.tala.entities.Response.Uninitialized
import dev.eighteentech.tala.repository.ItemsRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val  repository: ItemsRepository) : ViewModel() {

    private val _items = MutableStateFlow<Response<List<Item>>>(Uninitialized)
    val items : StateFlow<Response<List<Item>>> get() = _items

    fun fetchItems(){
        _items.value = Loading
        viewModelScope.launch {
            _items.value = withContext(IO){
                repository.getItems()
            }
        }
    }
}