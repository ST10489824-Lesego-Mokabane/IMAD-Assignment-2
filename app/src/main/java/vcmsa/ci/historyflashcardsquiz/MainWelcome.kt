package vcmsa.ci.historyflashcardsquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainWelcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        // Initializing all elements
        val welcomeTxt = findViewById<TextView>(R.id.welcomeTxt)
        val descriptionTxt = findViewById<TextView>(R.id.descriptionTxt)
        val diveInButton = findViewById<Button>(R.id.diveInBtn)
        val completeButton = findViewById<Button>(R.id.completeBtn)

        // Adding a welcome message and the description of the app
        welcomeTxt.text = "Welcome to History True/False Quiz!!"
        descriptionTxt.text = "Test your brain one statement at a time!"

        // Adding functionality to the dive in button
        diveInButton.setOnClickListener {
            // To start the quiz activity
            val intent = Intent(this, MainQuiz::class.java)
            startActivity(intent)

        }

        // Adding functionality to the complete button
        completeButton.setOnClickListener {
            // close the app
            finish()
        }

    }
}
