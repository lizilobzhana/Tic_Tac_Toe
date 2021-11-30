package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var refreshButton: Button
    private lateinit var player1: TextView
    private lateinit var player2: TextView

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if(buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if(activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }
        else{
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {
        var winnerPlayer = 0
        var score1 = 0
        var score2 = 0
        if((firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) ||
            (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) ||
            (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) ||
            (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) ||
            (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) ||
            (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) ||
            (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) ||
            (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7))){
            winnerPlayer = 1
        }
        if((secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) ||
            (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) ||
            (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) ||
            (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) ||
            (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) ||
            (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) ||
            (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) ||
            (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7))){
            winnerPlayer = 2
        }
        if (winnerPlayer == 1){
            Toast.makeText(this,"First Player Won!!!", Toast.LENGTH_SHORT).show()
            disableButtons()
        }
        if (winnerPlayer == 2){
            Toast.makeText(this,"Second Player Won!!!", Toast.LENGTH_SHORT).show()
            disableButtons()
        }
        if (!(button1.isEnabled) && !(button2.isEnabled) && !(button3.isEnabled) && !(button4.isEnabled) &&
            !(button5.isEnabled) && !(button6.isEnabled) && !(button7.isEnabled) && !(button8.isEnabled) &&
            !(button1.isEnabled) && winnerPlayer != 1 && winnerPlayer != 2){
            Toast.makeText(this, "DRAW!!!", Toast.LENGTH_SHORT).show()
        }
        if (winnerPlayer == 1){
            score1 ++
        }
        if (winnerPlayer == 2){
            score2 ++
        }
        if (winnerPlayer != 0){
            player1.text = score1.toString()
            player2.text = score2.toString()
        }

    }

    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        refreshButton = findViewById(R.id.refreshButton)
        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }

    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }

    fun refreshClick(view: View) {
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        button1.setBackgroundColor(Color.GRAY)
        button2.setBackgroundColor(Color.GRAY)
        button3.setBackgroundColor(Color.GRAY)
        button4.setBackgroundColor(Color.GRAY)
        button5.setBackgroundColor(Color.GRAY)
        button6.setBackgroundColor(Color.GRAY)
        button7.setBackgroundColor(Color.GRAY)
        button8.setBackgroundColor(Color.GRAY)
        button9.setBackgroundColor(Color.GRAY)

        activePlayer = 1
        firstPlayer.clear()
        secondPlayer.clear()
    }

}