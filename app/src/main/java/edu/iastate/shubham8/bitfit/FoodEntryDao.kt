package edu.iastate.shubham8.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodEntryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(foodEntry: FoodEntry)

    @Query("SELECT * FROM food_entries ORDER BY id DESC")
    fun getAllFoodEntries(): Flow<List<FoodEntry>>
}
