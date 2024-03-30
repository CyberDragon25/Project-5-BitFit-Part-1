package edu.iastate.shubham8.bitfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iastate.shubham8.bitfit.FoodDatabase.Companion.getDatabase
import edu.iastate.shubham8.bitfit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val foodDatabase = FoodDatabase.getDatabase(this)
    val foodEntryDao = foodDatabase.foodEntryDao()

    private lateinit var binding: ActivityMainBinding
    private val foodViewModel: FoodViewModel by viewModels { FoodViewModelFactory(FoodRepository(foodEntryDao)) }
    private lateinit var foodListAdapter: FoodListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodListAdapter = FoodListAdapter()

        binding.recyclerViewFoodEntries.apply {
            adapter = foodListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

//        val foodEntries = foodViewModel.allFoodEntries.value = foodEntries?.let { foodListAdapter.setItems(it) }

        binding.buttonAddFood.setOnClickListener {
            startActivity(Intent(this, AddFoodActivity::class.java))
        }
    }
}
