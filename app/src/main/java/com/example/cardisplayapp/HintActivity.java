package com.example.cardisplayapp;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.example.cardisplayapp.MainActivity.switchState;

public class HintActivity extends AppCompatActivity {

    String carImageResource;
    String carMake;
    ArrayList<String> toyotaCarList = new ArrayList<>();
    ArrayList<String> nissanCarList = new ArrayList<>();
    ArrayList<String> hondaCarList = new ArrayList<>();
    ArrayList<String> audiCarList = new ArrayList<>();
    ArrayList<String> microCarList = new ArrayList<>();
    ArrayList<String> bugattiCarList = new ArrayList<>();
    public static ArrayList<String> usedCars = new ArrayList<>();
    char[] wordDisplayArray;
    String wordDisplay;
    char tempStore;
    final String WIN_MESSAGE = "CORRECT!";
    final String LOST_MESSAGE = "WRONG!";
    int remainingAttempts = 3;
    Button submitButton;
    TextView countDownTimer2, remainingTimeLabel;
    int countdown = 20;
    CountDownTimer countDownTimer;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        toyotaCarList.addAll(Arrays.asList("toyota_fortuner", "toyota_yaris", "toyota_supra", "toyota_crown_de_luxe", "toyota_auris"));
        nissanCarList.addAll(Arrays.asList("nissan_murano", "nissan_leaf_2020", "nissan_navara", "nissan_gt_r", "nissan_altima"));
        hondaCarList.addAll(Arrays.asList("honda_civic", "honda_accord", "honda_fit", "honda_crv", "honda_acura_nsx"));
        audiCarList.addAll(Arrays.asList("audi_r8", "audi_a5", "audi_a6", "audi_a1", "audi_a3"));
        microCarList.addAll(Arrays.asList("micro_tivoli", "micro_baic_x25", "micro_geely_gc2", "micro_emgrand", "micro_panda"));
        bugattiCarList.addAll(Arrays.asList("bugatti_veyron", "bugatti_chiron", "bugatti_la_voiture_noire", "bugatti_centodieci", "bugatti_galibier"));

        ImageView v1 = findViewById(R.id.random_image);
        submitButton = findViewById(R.id.userinput_submit_button);

        countDownTimer2 = findViewById(R.id.countdown_timer2);
        remainingTimeLabel = findViewById(R.id.remaining_time_label);
        remainingTimeLabel.setVisibility(View.INVISIBLE);

        Random random = new Random();

        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dfe39f"));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable);
        }

        while (true) {

            int carListRandom = random.nextInt(6);
            int randomNumber = random.nextInt(5);

            if (carListRandom == 0) {
                carImageResource = toyotaCarList.get(randomNumber);
                if (!usedCars.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    carMake = "TOYOTA";
                    break;
                } else {
                    continue;
                }
            }
            if (carListRandom == 1) {
                carImageResource = nissanCarList.get(randomNumber);
                if (!usedCars.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    carMake = "NISSAN";
                    break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                carImageResource = audiCarList.get(randomNumber);
                if (!usedCars.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    carMake = "AUDI";
                    break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                carImageResource = hondaCarList.get(randomNumber);
                if (!usedCars.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    carMake = "HONDA";
                    break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                carImageResource = bugattiCarList.get(randomNumber);
                if (!usedCars.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    carMake = "BUGATTI";
                    break;
                } else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                carImageResource = microCarList.get(randomNumber);
                if (!usedCars.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    carMake = "MICRO";
                    break;
                }
            }
        }
        if (switchState){
            remainingTimeLabel.setVisibility(View.VISIBLE);
            startCountDown();
        }
        usedCars.add(carImageResource);
        //Starting the game
        initializeGame();


        EditText userInput = findViewById(R.id.editTextTextPersonName);
        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //Each time the user inputs a letter from the keyboard
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Getting the first letter of the user input and temporary storing it
                if (s.length() != 0) {
                    tempStore = s.charAt(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    void checkLetter(char letter) {

        //Revealing the letter if the user input letter is available in the make given to find
        if (carMake.indexOf(letter) >= 0) {
            if (wordDisplay.indexOf(letter) < 0) {
                revealLetter(letter);
            }
        } else {
            //If all the 3 attempts of the user is exhausted
            if (remainingAttempts > 0) {
                remainingAttempts = remainingAttempts - 1;
                TextView textView = findViewById(R.id.textView4);
                textView.setText(String.valueOf(remainingAttempts));
            }
        }
    }

    void revealLetter(char letter) {
        int letterIndex = carMake.indexOf(letter);

        //Storing the user input letter in a array if it's correct
        while (letterIndex >= 0) {
            wordDisplayArray[letterIndex] = carMake.charAt(letterIndex);
            //Checking whether the same letter has occurred elsewhere in the word that needs to be guessed
            letterIndex = carMake.indexOf(letter, letterIndex + 1);
        }
    }

    void screenDisplay() {
        //Displaying on the screen
        TextView wordGuess = findViewById(R.id.textView3);
        StringBuilder formattedString = new StringBuilder();
        StringBuilder formattedString2 = new StringBuilder();
        for (char character : wordDisplayArray) {
            //Adding a space between characters before screen display
            formattedString.append(character).append(" ");
            formattedString2.append(character);
        }
        wordGuess.setText(formattedString.toString());

        TextView triesLeft = findViewById(R.id.resultView);
        if (remainingAttempts == 0 && formattedString2.toString().equals(carMake)) {
            triesLeft.setTextColor(Color.GREEN);
            triesLeft.setText(WIN_MESSAGE);
            submitButton.setText(R.string.next_button);
        } else if (formattedString2.toString().equals(carMake)) {
            triesLeft.setTextColor(Color.GREEN);
            triesLeft.setText(WIN_MESSAGE);
            submitButton.setText(R.string.next_button);
        } else if (remainingAttempts == 0) {
            triesLeft.setTextColor(Color.RED);
            triesLeft.setText(LOST_MESSAGE);
            TextView correctMake = findViewById(R.id.correct_make);
            correctMake.setTextColor(Color.YELLOW);
            correctMake.setText(carMake);
            submitButton.setText(R.string.next_button);
        }
    }

    void initializeGame() {
        wordDisplayArray = carMake.toCharArray();
        //Adding dashes to the no of letters available in the word that needs to be guessed
        for (int i = 0; i < wordDisplayArray.length; i++) {
            wordDisplayArray[i] = '_';
        }
        wordDisplay = Arrays.toString(wordDisplayArray);
        screenDisplay();

    }

    public void submitLetter(View view) {
        //Proceeding to a new screen
        if (submitButton.getText().equals("NEXT")) {
            Intent refresh = getIntent();
            overridePendingTransition(0, 0);
            finish();
            startActivity(refresh);
            overridePendingTransition(0, 0);
        }

        //Checking the temporary stored user input letter is available in the word that needs to be guessed
        tempStore = Character.toUpperCase(tempStore);
        checkLetter(tempStore);
        screenDisplay();
    }

    //Starting the countdown timer of 20 seconds
    void startCountDown() {
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (remainingAttempts !=0) {
                    countDownTimer2.setText(String.valueOf(countdown));
                    countdown--;
                }
            }

            @Override
            public void onFinish() {
                countDownTimer2.setText(String.valueOf(countdown));
                tempStore = Character.toUpperCase(tempStore);
                checkLetter(tempStore);
                screenDisplay();
                //Restarting the countdown timer if all the attempts are not exhausted
                if (remainingAttempts !=0){
                    countdown = 20;
                    startCountDown();
                }
            }
        }.start();
    }
}