package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class PiratePlacesActivity : AppCompatActivity() {
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var buildingTextView: TextView
    private lateinit var namesTextView: TextView

    private val buildingsBank = listOf(
        Building(R.string.building_name1, R.string.person_name),
        Building(R.string.building_name2, R.string.person_name2),
        Building(R.string.building_name3, R.string.person_name3),
        Building(R.string.building_name4, R.string.person_name4),
        Building(R.string.building_name5, R.string.person_name5),
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pirate_places)

        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)
        buildingTextView = findViewById(R.id.building_name)
        namesTextView = findViewById(R.id.person_name)

        previousButton.setOnClickListener { view: View ->
            // Do something in response to the click here
            Toast.makeText(
                this,
                R.string.first_place_toast,
                Toast.LENGTH_SHORT
            )
                .show()
        }
        nextButton.setOnClickListener {
            Toast.makeText(
                this,
                R.string.last_place_toast,
                Toast.LENGTH_SHORT
            )
                .show()
            currentIndex = (currentIndex + 1) % buildingsBank.size
            //val buildingTextResId = buildingsBank[currentIndex].textResId
            //buildingTextView.setText(buildingTextResId)
            updateBuilding()
        }
        updateBuilding()
    }

    private fun updateBuilding() {
        val buildingTextResId = buildingsBank[currentIndex].textResId
        buildingTextView.setText(buildingTextResId)
    }
}

