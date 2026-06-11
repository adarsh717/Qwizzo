package com.example.qwizzo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
class QuizActivity : AppCompatActivity() {

    lateinit var tvQuestion : TextView
    lateinit var rbOption1 : RadioButton
    lateinit var rbOption2 : RadioButton
    lateinit var rbOption3 : RadioButton
    lateinit var rbOption4 : RadioButton
    lateinit var nextQuestion : MaterialButton
    lateinit var prev : MaterialButton
    lateinit var radioGroup: RadioGroup

    private var currentQuestionIndex=0
    private var score=0

    private val questionList = listOf(

        Question(
            "What does CPU stand for?",
            listOf("Central Processing Unit", "Computer Processing Unit", "Central Program Unit", "Control Processing Unit"),
            0
        ),

        Question(
            "What does RAM stand for?",
            listOf("Random Access Memory", "Read Access Memory", "Rapid Access Module", "Random Application Memory"),
            0
        ),

        Question(
            "Which device is used to display output?",
            listOf("Keyboard", "Mouse", "Monitor", "Scanner"),
            2
        ),

        Question(
            "Which company developed the Android operating system?",
            listOf("Apple", "Microsoft", "Google", "IBM"),
            2
        ),

        Question(
            "What is the full form of HTML?",
            listOf("Hyper Text Markup Language", "High Text Markup Language", "Hyper Transfer Markup Language", "Home Tool Markup Language"),
            0
        ),

        Question(
            "Which of the following is a web browser?",
            listOf("Windows", "Chrome", "Linux", "Android"),
            1
        ),

        Question(
            "Which data structure follows FIFO?",
            listOf("Stack", "Queue", "Tree", "Graph"),
            1
        ),

        Question(
            "Which data structure follows LIFO?",
            listOf("Queue", "Array", "Stack", "Linked List"),
            2
        ),

        Question(
            "What does URL stand for?",
            listOf("Uniform Resource Locator", "Universal Resource Link", "Uniform Reference Link", "Universal Reference Locator"),
            0
        ),

        Question(
            "Which protocol is used to transfer web pages?",
            listOf("FTP", "SMTP", "HTTP", "TCP"),
            2
        ),

        Question(
            "What is the brain of the computer?",
            listOf("RAM", "CPU", "Hard Disk", "Motherboard"),
            1
        ),

        Question(
            "Which language is officially recommended for Android development?",
            listOf("Python", "Kotlin", "PHP", "C"),
            1
        ),

        Question(
            "Which database language is used to query data?",
            listOf("HTML", "CSS", "SQL", "XML"),
            2
        ),

        Question(
            "What does SQL stand for?",
            listOf("Structured Query Language", "Simple Query Language", "System Query Language", "Sequential Query Language"),
            0
        ),

        Question(
            "Which of the following is an operating system?",
            listOf("Windows", "Google", "Chrome", "Intel"),
            0
        ),

        Question(
            "Which network device connects multiple computers in a LAN?",
            listOf("Router", "Switch", "Modem", "Printer"),
            1
        ),

        Question(
            "What is the default port number of HTTP?",
            listOf("21", "25", "80", "443"),
            2
        ),

        Question(
            "Which keyword is used to create an object in Java?",
            listOf("class", "static", "new", "public"),
            2
        ),

        Question(
            "Which of the following is not a programming language?",
            listOf("Java", "Python", "HTML", "C++"),
            2
        ),

        Question(
            "What does IP stand for in networking?",
            listOf("Internet Protocol", "Internal Program", "Internet Program", "Internal Protocol"),
            0
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvQuestion=findViewById(R.id.tvQuestion)
        rbOption1=findViewById(R.id.rbOption1)
        rbOption2=findViewById(R.id.rbOption2)
        rbOption3=findViewById(R.id.rbOption3)
        rbOption4=findViewById(R.id.rbOption4)

        radioGroup=findViewById(R.id.radioGroup)



        nextQuestion=findViewById(R.id.nextQuestionBtn)
        prev=findViewById(R.id.preQuestion)




val toolbar = findViewById<Toolbar>(R.id.quizToolBar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // enable back button in toolbar.

        showQuestion()

nextQuestion.setOnClickListener {

    saveAns()

    val selected = getSelected()

    val currentQuestion = questionList[currentQuestionIndex]
    currentQuestion.correctAnswer

//    if (selected == currentQuestion.correctAnswer){
//        score++;
//    }

    if (currentQuestionIndex < questionList.size - 1) {
        currentQuestionIndex++
        showQuestion()

    }
}

    prev.setOnClickListener {
        saveAns()

        if (currentQuestionIndex > 0){
            currentQuestionIndex--
            showQuestion()
        }
    }

 // call show question function

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.quizmenu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        } //handle back button click


        return when(item.itemId){



            R.id.restart->{
                // restart quiz logic
                return true
            }

            R.id.quit->{
                // quit logic
                return true
            }

            R.id.about->{
                // about code
                return true
            }

            else ->{
                super.onOptionsItemSelected(item)
            }
        }

    }

    //function to show questions.
    private fun showQuestion(){


        val currentIndex = questionList[currentQuestionIndex]
        currentIndex.correctAnswer
        tvQuestion.text=currentIndex.question

        rbOption1.text=currentIndex.options[0]
        rbOption2.text=currentIndex.options[1]
        rbOption3.text=currentIndex.options[2]
        rbOption4.text=currentIndex.options[3]

    }

    private fun getSelected(): Int{
        return when(radioGroup.checkedRadioButtonId){
            R.id.rbOption1 -> 0
            R.id.rbOption2 -> 1
            R.id.rbOption3 -> 2
            R.id.rbOption4 -> 3
            else -> -1
        }
    }

    private fun saveAns(){
        val currentQuestion = questionList[currentQuestionIndex]
        currentQuestion.selectedAnswer=when (radioGroup.checkedRadioButtonId) {
            R.id.rbOption1 -> 0
            R.id.rbOption2 -> 1
            R.id.rbOption3 -> 2
            R.id.rbOption4 -> 3
            else -> -1
        }
    }
}