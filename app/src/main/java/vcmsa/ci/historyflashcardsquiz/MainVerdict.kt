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

        // Initializing the elements
        val viewVerdictTxt = findViewById<TextView>(R.id.viewVerdictTxt)
        val freshStartBtn = findViewById<Button>(R.id.freshStartBtn)
        val leaveBtn = findViewById<Button>(R.id.leaveBtn)


        // Load questions and answers from the previous screen
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val viewVerdict = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                viewVerdictTxt.append("${i + 1}. ${questions[i]}\n")
                viewVerdictTxt.append("   Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            viewVerdictTxt.text = viewVerdictTxt.toString()
        } else{
            viewVerdictTxt.text = "Verdict data unavailable."
        }

        // Adding functionality to the fresh start button
        freshStartBtn.setOnClickListener {
            startActivity(Intent(this, MainQuiz::class.java))
        }

        // Adding functionality to the leave button
        leaveBtn.setOnClickListener {
            finishAffinity() // Leaves the application
            exitProcess(0)
        }
    }
}