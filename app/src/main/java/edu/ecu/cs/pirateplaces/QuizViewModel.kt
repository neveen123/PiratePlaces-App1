package edu.ecu.cs.pirateplaces

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {
    var currentIndex = 0
    private val buildingsBank = listOf(
        Building(R.string.building_name1, R.string.person_name),
        Building(R.string.building_name2, R.string.person_name2),
        Building(R.string.building_name3, R.string.person_name3),
        Building(R.string.building_name4, R.string.person_name4),
        Building(R.string.building_name5, R.string.person_name5),
    )
    val building_name: Int
        get()= buildingsBank[currentIndex].textResId

    val people_names: Int
        get() = buildingsBank[currentIndex].person_name

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % buildingsBank.size
    }
    }
