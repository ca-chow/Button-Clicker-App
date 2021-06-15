package academy.learnprogramming.buttonclickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    //"?" makes a variable a nullable type (or it can be null)
    //we init variables to null because we don't know what values they will have until
    // setContentView() runs

    //Don't need the following code
    //private var userInput: EditText? = null
    //private var button: Button? = null
    //private var timesClicked = 0
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: pressed")

        super.onCreate(savedInstanceState)
        //if onCreate can't finish using bundle, super method has a chance to work on the data
        setContentView(R.layout.activity_main) //uses "activity_main.xml" to create the layout

        //the following is not the definitive way to do things

        //all widgets are views
        //view is an android class that widgets extend - have similar behavior ie. put on layout
        //findViewById checks the layout and matches widgets according to their ids
        //userInput = findViewById<EditText>(R.id.editText)
        //button = findViewById<Button>(R.id.button)

        //userInput and button become val because we do not need to edit them later
            //we can also get rid of the question marks when we call those variables
            //because they can no longer be null
        val userInput: EditText = findViewById<EditText>(R.id.editText)
        userInput.setText("")
        val button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.movementMethod = ScrollingMovementMethod()
        textView?.text = ""

        //if a widget is being interacted with - there is a callback func (ie. onClickListener())
        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick: pressed")

                textView?.append(userInput.text)
                //userInput?.text because otherwise it will
                // be a type mismatch btw CharSequence and EditText
                textView?.append("\n")
                //userInput.text.clear()
                userInput.setText("")
            }
        })
    }
}