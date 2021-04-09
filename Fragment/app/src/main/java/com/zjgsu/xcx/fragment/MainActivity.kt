package com.zjgsu.xcx.fragment

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    /**android.os public final class Bundle
    extends android.os.BaseBundle
    implements Cloneable, android.os.Parcelable(package)
    A mapping from String keys to various Parcelable values*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val br: BroadcastReceiver = MyBroadcastReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(br, filter)


        /*create a button (defined by the R.id.button)
        * in some places the findViewById is omitted by some plugins*/
        val button = findViewById<Button>(R.id.button)
        /*add dynamic fragment:set the Button instance's onClickListener to response the click event properly */
        button.setOnClickListener {
            /*replaceFragment() is a function defined by ourselves(it's not a built in function of the Button*/
//            replaceFragment(AnotherRightFragment())
            /*make a toast:*/
            Toast.makeText(this, "test the implicit intent", Toast.LENGTH_LONG).show()
            /*test the implicit intent */
            // Create the text message with a string
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                /**android.content.Intent public Intent putExtra(String name,
                String value)
                Add extended data to the intent. The name must include a package prefix, for example the app com.android.contacts would use names like "com.android.contacts.ShowAll".

                Params:
                name – The name of the extra data, with package prefix.
                value – The String data value.
                Returns:
                Returns the same Intent object, for chaining multiple calls into a single statement.*/
                putExtra(Intent.EXTRA_TEXT, "textMessage")
                type = "text/plain"
            }

// Verify that the intent will resolve to an activity
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }
        }
        //
    }

    /**
     * the function takes Fragment instance as its parameter.
     * the Fragment may a java/kt class with a bracket (to get the Fragment instance as a parameter.*/
    private fun replaceFragment(fragment: Fragment) {
        /**androidx.fragment.app.FragmentActivity @NonNull
        public androidx.fragment.app.FragmentManager getSupportFragmentManager()
        Return the FragmentManager for interacting with fragments associated with this activity.*/
        val fragmentManager = supportFragmentManager

        /**with the help of the FragmentManager instance's beginTransaction()
         *  to get/create a transaction instance*/
        /**androidx.fragment.app.FragmentManager @NonNull
         *      public abstract androidx.fragment.app.FragmentTransaction beginTransaction()
         *Start a series of edit operations on the Fragments associated with this FragmentManager.
         *Note: A fragment transaction can only be created/committed prior to an activity saving its state.
         * If you try to commit a transaction after FragmentActivity.onSaveInstanceState() (and prior to a following FragmentActivity.onStart or FragmentActivity.onResume(), you will get an error. This is because the framework takes care of saving your current fragments in the state, and if changes are made after the state is saved then they will be lost.
         * return:androidx.fragment.app.FragmentTransaction
         */
        val transaction = fragmentManager.beginTransaction()
        /*according the resource id parameter1 and the fragment instance as parameter2 to complete the call
        * of the replace()*/
        transaction.replace(R.id.rightLayout, fragment)
        /*commit()the transaction*/
        transaction.commit()
    }
}