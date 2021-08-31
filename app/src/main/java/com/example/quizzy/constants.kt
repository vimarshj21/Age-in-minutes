package com.example.quizzy

object constants{

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORECT_ANSWERS: String="correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1 ,"What brand does this logo belongs to?",
        R.drawable.mc_donalds,
            "Burger King",
            "McDonalds",
            "Pizza Hut",
            "Dominos",
            2

        )

        questionsList.add(que1)

        val que2 = Question(2 ,"What brand does this logo belongs to?",
            R.drawable.batman,
            "Batman",
            "Spiderman",
            "Black Devil",
            "Shaktiman",
            1

        )

        questionsList.add(que2)

        val que3 = Question(3 ,"What brand does this logo belongs to?",
            R.drawable.shell,
            "Sunrise",
            "Tesco",
            "Royal Dutch Shell",
            "Sunfeast",
            3

        )

        questionsList.add(que3)

        val que4 = Question(4 ,"What brand does this logo belongs to?",
            R.drawable.apple,
            "Xiaomi",
            "Asus",
            " Apple",
            "Lenovo",
            3

        )

        questionsList.add(que4)

        val que5 = Question(5 ,"What brand does this logo belongs to?",
            R.drawable.roxy,
            "Roxy",
            "Calvin Klein",
            " Gucci",
            "H&M",
            1

        )

        questionsList.add(que5)

        val que6 = Question(6 ,"What brand does this logo belongs to?",
            R.drawable.volkswagen,
            "Audi",
            "Volkswagen",
            " Honda",
            "Mahindra",
            2

        )

        questionsList.add(que6)

        val que7 = Question(7 ,"What brand does this logo belongs to?",
            R.drawable.walmart,
            "Amazon",
            "Flipkart",
            " Big Basket",
            "Walmart",
            4

        )

        questionsList.add(que7)

        val que8 = Question(8 ,"What brand does this logo belongs to?",
            R.drawable.pepsi,
            "Coca Cola",
            "Pepsi",
            "Mountain Dew",
            "Red Bull",
            2

        )

        questionsList.add(que8)

        val que9 = Question(9 ,"What brand does this logo belongs to?",
            R.drawable.mitsubishi,
            "Mitsubishi",
            "Nisaan",
            " Muthoot",
            "Kalyan",
            1

        )

        questionsList.add(que9)

        val que10 = Question(10 ,"What brand does this logo belongs to?",
            R.drawable.sony,
            "Samsung",
            "Sony Viao",
            " Lloyd",
            "LG",
            2

        )

        questionsList.add(que10)

        return questionsList
    }
}