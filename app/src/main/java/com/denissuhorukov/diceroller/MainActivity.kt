package com.denissuhorukov.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val firstDiceImage: ImageView = findViewById(R.id.firstDiceImageView)
        val secondDiceImage: ImageView = findViewById(R.id.secondDiceImageView)
        var result: Int = 0
        val resultText: TextView = findViewById(R.id.textView)

        rollButton.setOnClickListener {
            result = 0
            resultText.text = ""
            result += rollDice(firstDiceImage)
            result += rollDice(secondDiceImage)
            resultText.text = "Rolled: ${result}"
        }
    }

    private fun rollDice(diceImage: ImageView): Int {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()

        return diceRoll
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}