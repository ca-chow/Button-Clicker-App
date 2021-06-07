package academy.learnprogramming.buttonclickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() { //"?" makes a variable a nullable type
    private var userInput: EditText? = null
    private var button: Button? = null
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //if onCreate can't finish using bundle, super method has a chance to work on the data
        setContentView(R.layout.activity_main) //uses "activity_main.xml" to create the layout

        //all widgets are views
        userInput = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)

    }
}