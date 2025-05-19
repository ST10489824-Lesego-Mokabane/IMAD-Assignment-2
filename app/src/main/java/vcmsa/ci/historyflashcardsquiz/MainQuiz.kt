package vcmsa.ci.historyflashcardsquiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainQuiz : AppCompatActivity() {

    // Initializing all elements
    private lateinit var questionMessage: TextView
    private lateinit var questionsTxt: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var outputTxt: TextView
    private lateinit var nextQuestionButton: Button

    companion object {
        // The questions which are going to be displayed
        val questions = arrayOf(
            "The apartheid rule was established in the 19th century",
            "The san people are the indigenous people of south africa",
            "South Africa gained independence from Britain in 1910",
            "The Sharpeville massacre occurred on April 1, 1960",
            "Desmond Tutu was a key figure in the anti-apartheid movement"
        )
        // The answers in a boolean array
        val answers = booleanArrayOf(false, true, true, false,true)
    }

    private var currentQuestionIndex = 0 // Keeps track of the current question index
    private var ranking = 0 // Stores the ranking of the user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        // Finding the views by their IDs
        questionMessage = findViewById(R.id.questionMessageTxt)
        questionsTxt = findViewById(R.id.questionsTxt)
        trueButton = findViewById(R.id.trueBtn)
        falseButton = findViewById(R.id.falseBtn)
        outputTxt = findViewById(R.id.outputTxt)
        nextQuestionButton = findViewById(R.id.nextQuestionBtn)

        //Displays the first question
        displayQuestion()

        // Adding functionality to the true and false buttons
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        // Adding functionality to the next question button
        nextQuestionButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                outputTxt.text = "" // Clears the output
                trueButton.isEnabled = true // Enables the buttons
                falseButton.isEnabled = true
            } else {
                // Starts the next activity
                val intent = Intent(this, MainRanking::class.java)
                intent.putExtra("ranking", ranking)
                startActivity(intent)
                finish() // Finishes the activity so that the user can not go back
            }
        }
        nextQuestionButton.isEnabled = false // Disables the next question button at the beginning

    }


    private fun displayQuestion() {
        questionsTxt.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            outputTxt.text = "Accurate!"
            outputTxt.setTextColor(Color.GREEN)
            ranking++
        } else {
            outputTxt.text = "Inaccurate."
            outputTxt.setTextColor(Color.RED)
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextQuestionButton.isEnabled = true

    }

}
