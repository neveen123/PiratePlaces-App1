package edu.ecu.cs.pirateplaces

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_ANSWER_IS_TRUE=
   "edu.ecu.cs.pirateplaces.answer_is_true"

class CheckingInActivity : AppCompatActivity() {

    private lateinit var answerTextView: TextView
    private lateinit var showCheckInButton: Button
    private var answerIsTrue = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checking_in)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        showCheckInButton = findViewById(R.id.checkin_button)
        showCheckInButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.building_name2
                else ->R.string.previous_button
            }
            answerTextView.setText(answerText)
        }
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Int): Intent {
            return Intent(packageContext, CheckingInActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}







