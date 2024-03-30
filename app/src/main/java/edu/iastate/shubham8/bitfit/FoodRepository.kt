package edu.iastate.shubham8.bitfit

import androidx.lifecycle.LiveData
import edu.iastate.shubham8.bitfit.FoodEntry
import kotlinx.coroutines.flow.Flow

class FoodRepository(private val foodEntryDao: FoodEntryDao) {

    fun getAllFoodEntries(): Flow<List<FoodEntry>> {
        return foodEntryDao.getAllFoodEntries()
    }

    suspend fun insert(foodEntry: FoodEntry) {
        foodEntryDao.insert(foodEntry)
    }
}
