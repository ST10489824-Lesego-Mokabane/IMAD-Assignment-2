package vcmsa.ci.historyflashcardsquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainRanking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ranking)

        //Code attribution for linking elements by ID
        //This method was taken from the
        // IMAD5112 Module Manual 2025
        //Page 41

        // linking all the elements
        val rankingMessageTxt = findViewById<TextView>(R.id.rankingMessageTxt)
        val rankingTxt = findViewById<TextView>(R.id.rankingTxt)
        val commentsTxt = findViewById<TextView>(R.id.commentsTxt)
        val checkVerdictBtn = findViewById<Button>(R.id.checkVerdictBtn)
        val terminateBtn = findViewById<Button>(R.id.terminateBtn)

        rankingMessageTxt.text = "Your Ranking:"

        val ranking = intent.getIntExtra("ranking", 0)
        rankingTxt.text = "Your ranking: $ranking/5"

        val comments = if (ranking >= 3) {
            "Excellent work!"
        } else {
            "Progress takes time and effort!"
        }
        commentsTxt.text = comments

        checkVerdictBtn.setOnClickListener {
            //Code attribution for the start activity
            //This method was taken from the
            //IMAD5112 Module Manual 2025
            //Page 64

            // Starts the review Screen and pass the questions and answers
            val intent = Intent(this, MainVerdict::class.java)
            intent.putExtra("questions", MainQuiz.questions)
            intent.putExtra("questions", MainQuiz.answers)
            startActivity(intent)
        }

        // Adding functionality to the terminate button
        terminateBtn.setOnClickListener {
            finish() // Closes the app
        }
    }
}