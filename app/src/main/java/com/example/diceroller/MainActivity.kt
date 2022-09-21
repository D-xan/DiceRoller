package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button=findViewById(R.id.button)
        //This OnclickListner tells the code that what will happen next after pressing the button
        rollButton.setOnClickListener()
        {
            rollDice()
            {

            }
        }
    }
//Roll the Dice and update the screen with the result.
    private fun rollDice(function: () -> Unit) {
        val dice= Dice(6)
    //Create new Dice object with 6 sides and roll the dice.
        val diceRoll = dice.roll()
    //Find the imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when(diceRoll)
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
//Update the imageView with the correct drawable resource ID
    diceImage.setImageResource(drawableResource)
    //Use setImageResource() to change the image that's displayed in an ImageView
    //Update the content description
    diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int){
        fun roll(): Int {
            return(1..numSides).random()
        }
    }
}