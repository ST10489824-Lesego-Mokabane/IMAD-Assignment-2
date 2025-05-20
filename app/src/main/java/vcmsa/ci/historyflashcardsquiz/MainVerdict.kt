package vcmsa.ci.historyflashcardsquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainVerdict : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_verdict)

        //Code attribution for linking elements by ID
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 41

        // Linking all the elements
        val viewVerdictTxt = findViewById<TextView>(R.id.viewVerdictTxt)
        val freshStartBtn = findViewById<Button>(R.id.freshStartBtn)
        val leaveBtn = findViewById<Button>(R.id.leaveBtn)


        // Load questions and answers from the previous screen
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val viewVerdict = StringBuilder()
        
        //Code attribution for logical operators
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 52
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                //Code attribution for representing a new line and leaving one line open
                //This method was taken from the
                //IMAD5112 Module Manual 2025
                //Page 67
                viewVerdictTxt.append("${i + 1}. ${questions[i]}\n")
                viewVerdictTxt.append("   Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            viewVerdictTxt.text = viewVerdictTxt.toString()
        } else{
            viewVerdictTxt.text = "Verdict data unavailable."
        }

        // Adding functionality to the fresh start button
        freshStartBtn.setOnClickListener {
            //Code attribution for the start activity
            //This method was taken from the
            //IMAD5112 Module Manual 2025
            //Page 64
            startActivity(Intent(this, MainQuiz::class.java))
        }

        // Adding functionality to the leave button
        leaveBtn.setOnClickListener {
            finishAffinity() // Leaves the application
            exitProcess(0)
        }
    }
}