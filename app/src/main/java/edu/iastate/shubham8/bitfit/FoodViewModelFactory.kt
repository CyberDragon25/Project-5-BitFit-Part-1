package edu.iastate.shubham8.bitfit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.iastate.shubham8.bitfit.FoodRepository

class FoodViewModelFactory(private val repository: FoodRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FoodViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
