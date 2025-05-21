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

        //Code attribution for linking elements by ID
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 41

        // Linking all elements by their IDs
        val welcomeTxt = findViewById<TextView>(R.id.welcomeTxt)
        val descriptionTxt = findViewById<TextView>(R.id.descriptionTxt)
        val diveInButton = findViewById<Button>(R.id.diveInBtn)
        val completeButton = findViewById<Button>(R.id.completeBtn)

        // Adding a welcome message and the description of the app
        welcomeTxt.text = "Welcome to History True/False Quiz!!"
        descriptionTxt.text = "Test your brain one statement at a time!"

        // Adding functionality to the dive in button
        diveInButton.setOnClickListener {
            //Code attribution for the start activity
            //This method was taken from the
            //IMAD5112 Module Manual 2025
            //Page 64

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
