package com.example.quizzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(constants.USER_NAME)
        tv_username.text = username

        val totalQuestions = intent.getIntExtra(constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(constants.CORECT_ANSWERS,0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions"

        btn_finish.setOnClickListener {  startActivity(Intent(this,MainActivity::class.java))}

    }
}