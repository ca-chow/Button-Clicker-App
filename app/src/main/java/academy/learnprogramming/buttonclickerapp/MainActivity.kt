package academy.learnprogramming.buttonclickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //"?" makes a variable a nullable type (or it can be null)
    //we init variables to null because we don't know what values they will have until
    // setContentView() runs
    private var userInput: EditText? = null
    private var button: Button? = null
    private var textView: TextView? = null
    private var timesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //if onCreate can't finish using bundle, super method has a chance to work on the data
        setContentView(R.layout.activity_main) //uses "activity_main.xml" to create the layout

        //the following is not the definitive way to do things

        //all widgets are views
        //view is an android class that widgets extend - have similar behavior ie. put on layout
        //findViewById checks the layout and matches widgets according to their ids
        userInput = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)

        //if a widget is being interacted with - there is a callback func (ie. onClickListener())
        button?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                timesClicked += 1
                textView?.append("\nThe button was clicked $timesClicked times.")
            }
        })
    }
}