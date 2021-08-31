package com.example.quizzy

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizzy2.*

class quizQuestionActivity : AppCompatActivity() ,View.OnClickListener{

    private var mCurrentPosition:Int = 1
    private var mQuestiondList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int =0
    private var mCorrectAnswers: Int=0
    private var mUsername:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzy2)

        mUsername = intent.getStringExtra(constants.USER_NAME)

        mQuestiondList = constants.getQuestions()

        setQuestion()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val question= mQuestiondList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestiondList!!.size){
            btn_submit.text= "FINISH"
        }else{
            btn_submit.text="SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_optionOne.text = question.optionOne
        tv_optionTwo.text = question.optionTwo
        tv_optionThree.text = question.optionThree
        tv_optionFour.text = question.optionFour

    }

    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()
        options.add(0,tv_optionOne)
        options.add(1,tv_optionTwo)
        options.add(1,tv_optionThree)
        options.add(3,tv_optionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(tv_optionOne,selectedOptionNum = 1)
            }
            R.id.tv_optionTwo ->{
                selectedOptionView(tv_optionTwo,selectedOptionNum = 2)
            }
            R.id.tv_optionThree ->{
                selectedOptionView(tv_optionThree,selectedOptionNum = 3)
            }
            R.id.tv_optionFour ->{
                selectedOptionView(tv_optionFour,selectedOptionNum = 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestiondList!!.size ->{
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(constants.USER_NAME, mUsername)
                            intent.putExtra(constants.CORECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(constants.TOTAL_QUESTIONS,mQuestiondList!!.size)
                            startActivity(intent)
                        }
                    }
                }
                else {
                 val question= mQuestiondList?.get(mCurrentPosition-1)
                 if (question!!.correctAnswer!= mSelectedOptionPosition){
                     answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                 } else{
                     mCorrectAnswers++
                 }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition== mQuestiondList!!.size){
                        btn_submit.text= "FINISH"
                    } else{
                        btn_submit.text= "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }

    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1 -> {
                tv_optionOne.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                tv_optionTwo.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                tv_optionThree.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 -> {
                tv_optionFour.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){


        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

}