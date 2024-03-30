package edu.iastate.shubham8.bitfit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FoodViewModel(private val repository: FoodRepository) : ViewModel() {

    val allFoodEntries: Flow<List<FoodEntry>> = repository.getAllFoodEntries()

    fun insert(foodEntry: FoodEntry) {
        viewModelScope.launch {
            repository.insert(foodEntry)
        }
    }
}
