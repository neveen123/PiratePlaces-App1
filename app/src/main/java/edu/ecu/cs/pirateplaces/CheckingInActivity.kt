package edu.ecu.cs.pirateplaces

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_PERSON_NAME= "edu.ecu.cs.pirateplaces.person_name"
const val EXTRA_CHECKED_IN= "edu.ecu.cs.pirateplaces.person_name"

class CheckingInActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var checkedInTextView: TextView
    private lateinit var showCheckInButton: Button
    private var visitor_name: String = ""
    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checking_in)

        visitor_name = intent.getStringExtra(EXTRA_PERSON_NAME) ?: ""
        nameTextView=findViewById(R.id.person_name)
        checkedInTextView=findViewById(R.id.checked_in_text_view)
        showCheckInButton = findViewById(R.id.checkin_button)

        showCheckInButton.setOnClickListener {
           setCheckedIn(true)
            updateBuilding()
        }

    }

    private fun updateBuilding(){
        nameTextView.setText(visitor_name)

        val message = if(answerIsTrue){
            R.string.checked_in
        }
        else{
            R.string.not_checked_in
        }
        checkedInTextView.setText(message)
    }

    private fun setCheckedIn(checkedIn: Boolean){
        this.answerIsTrue = true
        val data = Intent().apply { putExtra(EXTRA_CHECKED_IN,checkedIn) }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, visitor_name: Int): Intent {
            return Intent(packageContext, CheckingInActivity::class.java).apply {
                putExtra(EXTRA_PERSON_NAME, visitor_name)
            }
        }
    }
}







