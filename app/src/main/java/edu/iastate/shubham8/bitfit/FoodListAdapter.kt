package edu.iastate.shubham8.bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodListAdapter : RecyclerView.Adapter<FoodListAdapter.FoodEntryViewHolder>() {

    private var foodEntries: List<FoodEntry> = listOf()

    fun setItems(items: List<FoodEntry>) {
        foodEntries = items
        notifyDataSetChanged() // Notify RecyclerView that data has changed
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodEntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_entry, parent, false)
        return FoodEntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodEntryViewHolder, position: Int) {
        val currentFoodEntry = foodEntries[position]
        holder.bind(currentFoodEntry)
    }

    override fun getItemCount(): Int {
        return foodEntries.size
    }

    fun setFoodEntries(entries: List<FoodEntry>) {
        foodEntries = entries
        notifyDataSetChanged()
    }

    fun submitList(newList: List<FoodEntry>) {
        submitList(newList.toMutableList())
    }

    inner class FoodEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodNameTextView: TextView = itemView.findViewById(R.id.textViewFoodName)
        private val caloriesTextView: TextView = itemView.findViewById(R.id.textViewCalories)

        fun bind(foodEntry: FoodEntry) {
            foodNameTextView.text = foodEntry.foodName
            caloriesTextView.text = foodEntry.calories.toString()
        }
    }
}
