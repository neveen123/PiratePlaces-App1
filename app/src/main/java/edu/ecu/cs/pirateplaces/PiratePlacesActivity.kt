package edu.ecu.cs.pirateplaces

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

private const val TAG = "PiratePlacesActivity"
private const val KEY_INDEX = "index"


class PiratePlacesActivity : AppCompatActivity() {
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var checkInButton: Button
    private lateinit var buildingTextView: TextView
    private lateinit var namesTextView:TextView


    private val buildingsBank = listOf(
        Building(R.string.building_name1, R.string.person_name),
        Building(R.string.building_name2, R.string.person_name2),
        Building(R.string.building_name3, R.string.person_name3),
        Building(R.string.building_name4, R.string.person_name4),
        Building(R.string.building_name5, R.string.person_name5),
    )
    private var currentIndex = 0

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pirate_places)

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        quizViewModel.currentIndex = currentIndex

        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)
        //checkInButton = findViewById(R.id.checkin_button)
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
        nextButton.setOnClickListener { view: View ->
            if (quizViewModel.incrementNext) {
                quizViewModel.moveToNext()
                updateBuilding()
            } else {
                Toast.makeText(
                    this,
                    R.string.last_place_toast,
                    Toast.LENGTH_SHORT
                )
                    .show()}}



            //currentIndex = (currentIndex + 1) % buildingsBank.size
            //val buildingTextResId = buildingsBank[currentIndex].textResId
            //buildingTextView.setText(buildingTextResId)
            //quizViewModel.moveToNext()
            updateBuilding()

            namesTextView.setOnClickListener {
                // val intent = Intent(this, CheckingInActivity::class.java)
                //startActivity(intent)
             //  val answerIsTrue = quizViewModel.building_name
                val intent = CheckingInActivity.newIntent(this,quizViewModel.building_name)
                startActivity(intent)
            }
            updateBuilding()
        }
    override fun onSaveInstanceState(outState: Bundle) {
        //override fun onSaveInstanceState(savedInstanceState: Bundle) {
           // super.onSaveInstanceState(savedInstanceState)
            super.onSaveInstanceState(outState)
            outState.putInt(KEY_INDEX,quizViewModel.currentIndex)
            //Log.i(TAG, "onSaveInstanceState")
            //savedInstanceState.putInt(KEY_INDEX, quizViewModel.currentIndex)
        }

    private fun updateBuilding() {
            // val buildingTextResId = buildingsBank[currentIndex].textResId
            val buildingTextResId = quizViewModel.building_name
            //val namesTextResId = buildingsBank[currentIndex].person_name
            val namesTextResId = quizViewModel.people_names
            buildingTextView.setText(buildingTextResId)
            namesTextView.setText(namesTextResId)
        }
    }





