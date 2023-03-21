package com.example.myapplication.Model

import androidx.lifecycle.*
import com.example.myapplication.DB.ItemsRepository
import com.example.myapplication.Items.OneItem
import kotlinx.coroutines.launch
import java.util.*

class VModel(private val repository:ItemsRepository):ViewModel() {
    var items:LiveData<List<OneItem>> =repository.allItems.asLiveData()


    fun addItem(newItem:OneItem)=viewModelScope.launch {
        repository.insertItem(newItem)
    }

    /*fun updateItem(id: UUID, name:String,cost:String){
        val list = items.value
        val item = list!!.find { it.id == id }!!

        item.name = name
        item.cost=cost
        items.postValue(list)
    }*/

    fun updateItem(item: OneItem)=viewModelScope.launch {
        repository.updateItem(item)
    }

    fun deleteItem(item: OneItem)=viewModelScope.launch {
        repository.deleteItem(item)
    }

}

class ItemModelFactory(private val repository: ItemsRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(VModel::class.java)){
            return VModel(repository) as T
        }

        throw java.lang.IllegalArgumentException("UnknownClass")
    }
}