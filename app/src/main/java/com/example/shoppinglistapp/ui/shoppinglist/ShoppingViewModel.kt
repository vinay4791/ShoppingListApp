package com.example.shoppinglistapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.data.db.entitites.ShoppingItem
import com.example.shoppinglistapp.data.repositories.ShoppingRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repositories: ShoppingRepositories
) : ViewModel() {

    //If we want to start a coroutine we want to tell kotlin in which context we want to start it.
    // Here we start it in the main thread.
    //Room basically provides main safety so we lanch in main context
    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repositories.insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repositories.delete(item)
    }

    fun getAllShoppingItems() = repositories.getAllShoppingItems()


}