package com.zjgsu.xcx.fragment

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        /*设置基于Button的Toast*/
        /*借助kotlin的自动类型推导,可以不用指明Button类型(但是应该指定val/var;而且val优先)
        *androidx.appcompat.app.AppCompatActivity public <T extends android.view.View> T findViewById(@IdRes int id)
Description copied from class:
android.app.Activity Finds a view that was identified by the android:id XML attribute that was processed in onCreate.
Note: In most cases -- depending on compiler support -- the resulting view is automatically cast to the target class type. If the target class type is unconstrained, an explicit cast may be necessary.
Overrides:
findViewById in class Activity
Params:
id – the ID to search for
Returns:
a view with given ID if found, or null otherwise*/
        /*a view with given ID if found, or null otherwise*/
        val button1 = findViewById<Button>(R.id.buttonPanel)
        /*you should know that the setOnClickListener() is based the button1 instance :
        * response  to the click the button event: */
        button1.setOnClickListener {
            /*in the setOnClickListener(),we can set several respond events */
            Toast.makeText(this, "you clicked button1", Toast.LENGTH_LONG).show()
            /**get the intent instance:
             * android.content.Intent
             * public static final String ACTION_VIEW = "android.intent.action.VIEW"
            Activity Action: Display the data to the user.
            This is the most common action performed on data --
            it is the generic action you can use on a piece of data to get the most reasonable thing to occur.
            For example, when used on a contacts entry it will view the entry; when used on a mailto: URI it will bring up a compose window filled with the information supplied by the URI; when used with a tel: URI it will invoke the dialer.
            Input: getData is URI from which to retrieve data.
            Output: nothing*/
//            val intentTestKotlinFile=Intent(this,MainActivity::class.java)
//            startActivity(intentTestKotlinFile)
/*creat the alarmClock*/
           createAlarm("testTime",4,4)
//            /**您可以指定自己的操作，供 Intent 在您的应用内使用（或者供其他应用在您的应用中调用组件）。但是，您通常应该使用由Intent 类或其他框架类定义的操作常量。以下是一些用于启动 Activity 的常见操作：
//
//            ACTION_VIEW
//            如果您拥有一些某项 Activity 可向用户显示的信息（例如，要使用图库应用查看的照片；或者要使用地图应用查看的地址），请通过 Intent 将此操作与 startActivity() 结合使用。
//            ACTION_SEND
//            这也称为共享 Intent。如果您拥有一些用户可通过其他应用（例如，电子邮件应用或社交共享应用）共享的数据，则应使用 Intent 将此操作与 startActivity() 结合使用。
//            有关更多定义通用操作的常量，请参阅 Intent 类参考文档。其他操作在 Android 框架中的其他位置定义。例如，对于在系统的设置应用中打开特定屏幕的操作，将在 Settings中定义。
//            // Executed in an Activity, so 'this' is the Context
//            // The fileUrl is a string URL, such as "http://www.example.com/image.png"
//            val downloadIntent = Intent(this, DownloadService::class.java).apply {
//            data = Uri.parse(fileUrl)
//            }
//            startService(downloadIntent)
//             */
//            val intent = Intent(Intent.ACTION_VIEW).apply {
//                data = Uri.parse("https://www.baidu.com")
//            }
//            /**android.content.Intent public Intent(android.content.Context packageContext,
//            Class<?> cls)
//            Create an intent for a specific component. All other fields (action, data, type, class) are null, though they can be modified later with explicit calls. This provides a convenient way to create an intent that is intended to execute a hard-coded class name, rather than relying on the system to find an appropriate class for you; see setComponent for more information on the repercussions of this.
//
//            Params:
//            packageContext – A Context of the application package implementing this class.
//            cls – The component class that is to be used for the intent.*/
////            val intent2 = Intent(
////                this, MainActivity::class.java)
//            /*set action on the intent*/
////            intent.data = Uri.parse("https://www.baidu.com")
//            /*android.app.Activity public void startActivity(android.content.Intent intent)
//            Same as startActivity(Intent, Bundle) with no options specified.*/
//            startActivity(intent)

            /*destroy the activity:write the finish method in the setOnClickListener*/
            //finish()

        }
        /*write in java style:*/
//        Button button = (Button) findViewById(R.id.button_send);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Do something in response to button click
//            }
//        });

    }
    /*test the click method*/
    /** Called when the user touches the button */
    fun testClick(view: View) {
        Toast.makeText(this, "test the method testClick", Toast.LENGTH_SHORT).show()
//        val intent = Intent(Intent.ACTION_VIEW).apply {
//            data = Uri.parse("https://www.baidu.com")
//        }
        /*test the explicit intent(to call another activity by explicitly specified (the activity be called is written by java) */
//        val intent=Intent(this,testButtonInjava::class.java)
//        startActivity(intent)


        // Do something in response to button click
    }

    /*the onCreateOptionsMenu is responsible for loading the menu(and the items)
    the type of the parameter is declare after of the parameter name
    * */
    /*Initialize the contents of the Activity's standard options menu. You should place your menu items in to menu.
This is only called once, the first time the options menu is displayed.

    return the boolean type:(written after the function's name)*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        /*override the function of the Activity class,we can invoke the member function directly
        * like this:getMenuInflater()
        * don't be confused in the method invoke in the using of the class(or the class's instance
        *
        * what's more since we use are override the method in the class's interior,we can visit the property of the class (member variable)directly,rather than visit by getter method! */
        /*menu inflate 菜单加载器
        * invoke the inflate() function to load the menu
        * android.view.MenuInflater public void inflate(@MenuRes int menuRes,
                    android.view.Menu menu)
Inflate a menu hierarchy from the specified XML resource. Throws InflateException if there is an error.
* menuRes – Resource ID for an XML layout resource to load (e.g., R.menu.main_activity)
menu – The Menu to inflate into. The items and submenus will be added to this Menu.*/

        /**androidx.appcompat.app.AppCompatActivity @NonNull
        public android.view.MenuInflater getMenuInflater()
        Description copied from class:
        android.app.Activity Returns a MenuInflater with this context.
        Overrides:
        getMenuInflater in class Activity*/
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    /*override the onOptionsItemSelected
    *
    *
android.app.Activity This hook is called whenever an item in your options menu is selected. The default implementation simply returns false to have the normal processing happen (calling the item's Runnable or sending a message to its Handler as appropriate). You can use this method for any items for which you would like to do processing without those other facilities.
Derived classes should call through to the base class for it to perform the default menu handling.
Overrides:
onOptionsItemSelected in class Activity
Params:
item – The menu item that was selected.
Returns:
boolean Return false to allow normal menu processing to proceed, true to consume it here.
* 每当在选项菜单中选择一个项目时，就会调用此挂钩。 默认实现只是返回false以使正常处理发生（适当时调用该项目的Runnable或向其Handler发送消息）。 您可以将这种方法用于任何您想要对其进行处理而无需其他功能的项目。

派生类应调用基类，以执行默认菜单处理。

覆写：

类Activity中的onOptionsItemSelected

参数：

item –选定的菜单项。

返回值：

布尔值返回false以允许正常的菜单处理继续，返回true以在此处使用它。
* summary:respond the selected event*/
    /*do the event selected int the specified menu
    * the onOptionsItemSelected is similar to the setOnclickListener() :
    * such as :both of them could contain response event like toast and so on */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /**android.view.MenuItem
         *  public abstract int getItemId()
        Return the identifier for this menu item. The identifier can not be changed after the menu is created*/
        when (item.itemId) {
            /*which value would be selected depend on what you click in the main option in the app
            */
            R.id.add_item ->
                Toast.makeText(this, "you clicked add", Toast.LENGTH_LONG).show()
            R.id.remove_item -> Toast.makeText(this, "you clicked remove", Toast.LENGTH_LONG).show()

        }
        return true
    }
}