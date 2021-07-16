package academy.learnprogramming.buttonclickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() { //"?" makes a variable a nullable type
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
    /* Can get rid of these variables because:
    private var userInput: EditText? = null //can be local property
    private var button: Button? = null //can be local property
    private var timesClicked = 0 //changing app feature
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        //if onCreate can't finish using bundle, super method has a chance to work on the data
        setContentView(R.layout.activity_main) //uses "activity_main.xml" to create the layout

        //the following is not the definitive way to do things
        //all widgets are views
        val userInput: EditText = findViewById<EditText>(R.id.editText)
        val button: Button = findViewById<Button>(R.id.button)
        //userInput and button are vals because we do not change them after init
        //doesn't userInput's text keep changing? yes, but connecting the widget does not change

        userInput.setText("")
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = "" //string can be set to a textView's text property
        textView?.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener (object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick: called")
                textView?.append(userInput.text)
                textView?.append("\n")
                //string CANNOT be set to an editText's text property - cannot do like line 32
                userInput.setText("") //but we can set its text to ""
            }
        })
    }

    //Overriding activity lifecycle functions in the order they are usually called
    //does not affect computer performance but good format in general
    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }
}