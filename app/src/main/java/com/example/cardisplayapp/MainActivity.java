package com.example.cardisplayapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public Switch simpleSwitch;
    public static Boolean switchState = false;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleSwitch = (Switch) findViewById(R.id.switch1);
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dfe39f"));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable);
        }
    }

    public void openRandomImageActivity(View view) {
        //Storing the switch status inside a boolean variable
        switchState = simpleSwitch.isChecked();
        // Starting the random image activity screen
        Intent intent = new Intent(this, RandomImageActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openHintActivity(View view) {
        //Storing the switch status inside a boolean variable
        switchState = simpleSwitch.isChecked();
        // Starting the random image activity screen
        Intent intent = new Intent(this, HintActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openClickableImageActivity(View view) {
        //Storing the switch status inside a boolean variable
        switchState = simpleSwitch.isChecked();
        // Starting the random image activity screen
        Intent intent = new Intent(this, ClickableImageActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openAdvancedLevelActivity(View view) {
        //Storing the switch status inside a boolean variable
        switchState = simpleSwitch.isChecked();
        // Starting the random image activity screen
        Intent intent = new Intent(this, AdvancedLevelActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")

    public void onSwitchButtonClick(View view) {
    }
}

/*References
Hangman Game Idea
https://www.youtube.com/watch?v=HgH1DfH14uk&list=PLgTkNlNsy9gVCkeaoudJJWr4P3Gc-AV7f&index=1
Circular Image Views
https://stackoverflow.com/questions/22105775/imageview-in-circular-through-xml
Android button background images with effects
https://stackoverflow.com/questions/17145615/using-image-in-a-android-button-with-effects/17145721
https://stackoverflow.com/questions/7175873/how-to-set-button-click-effect-in-android
Countdown timer
https://developer.android.com/reference/android/os/CountDownTimer
Disable edit text auto focus
https://www.tutorialspoint.com/how-to-stop-edittext-from-gaining-focus-at-activity-startup-in-android
Reload Activity
https://stackoverflow.com/questions/3053761/reload-activity-in-android/6076299
Spinner with initial text
https://stackoverflow.com/questions/867518/how-to-make-an-android-spinner-with-initial-text-select-one
Spinner
https://stackoverflow.com/questions/13377361/how-to-create-a-drop-down-list
 */
