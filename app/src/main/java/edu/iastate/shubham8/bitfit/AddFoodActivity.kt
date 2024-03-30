package edu.iastate.shubham8.bitfit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import edu.iastate.shubham8.bitfit.databinding.ActivityAddFoodBinding

class AddFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddFoodBinding
    private val foodViewModel: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAddFood.setOnClickListener {
            addFoodEntry()
        }
    }

    private fun addFoodEntry() {
        val foodName = binding.editTextFoodName.text.toString().trim()
        val caloriesText = binding.editTextCalories.text.toString().trim()

        if (foodName.isEmpty() || caloriesText.isEmpty()) {
            // Handle empty fields if needed
            return
        }

        val calories = caloriesText.toInt()

        val foodEntry = FoodEntry(foodName = foodName, calories = calories)
        foodViewModel.insert(foodEntry)

        finish() // Close the activity after adding the food entry
    }
}
