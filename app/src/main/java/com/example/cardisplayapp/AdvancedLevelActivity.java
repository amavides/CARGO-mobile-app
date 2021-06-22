package com.example.cardisplayapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.example.cardisplayapp.MainActivity.switchState;

public class AdvancedLevelActivity extends AppCompatActivity {

    public String resource1;
    public String resource2;
    public String resource3;
    String carMake1;
    String carMake2;
    String carMake3;
    ArrayList<String> toyotaCarList = new ArrayList<>();
    ArrayList<String> nissanCarList = new ArrayList<>();
    ArrayList<String> hondaCarList = new ArrayList<>();
    ArrayList<String> audiCarList = new ArrayList<>();
    ArrayList<String> microCarList = new ArrayList<>();
    ArrayList<String> bugattiCarList = new ArrayList<>();
    public static ArrayList<String> alreadyGuessedCars = new ArrayList<>();
    int carListRandom;
    int randomNumber;
    TextView resultMessage, correctMake1, correctMake2, correctMake3, scoreCount, remainingCount, countDownTimer3, remainingTimeLabel;
    Button nextButton;
    EditText guess1, guess2, guess3;
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int remainingAttempts = 3;
    int totalScore;
    public static ArrayList<Integer> storeTotalScore = new ArrayList<>();
    int countdown = 20;
    CountDownTimer countDownTimer;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        toyotaCarList.addAll(Arrays.asList("toyota_fortuner","toyota_yaris", "toyota_supra", "toyota_crown_de_luxe", "toyota_auris"));
        nissanCarList.addAll(Arrays.asList("nissan_murano","nissan_leaf_2020","nissan_navara","nissan_gt_r","nissan_altima"));
        hondaCarList.addAll(Arrays.asList("honda_civic","honda_accord","honda_fit","honda_crv","honda_acura_nsx"));
        audiCarList.addAll(Arrays.asList("audi_r8","audi_a5","audi_a6","audi_a1","audi_a3"));
        microCarList.addAll(Arrays.asList("micro_tivoli","micro_baic_x25","micro_geely_gc2","micro_emgrand","micro_panda"));
        bugattiCarList.addAll(Arrays.asList("bugatti_veyron","bugatti_chiron","bugatti_la_voiture_noire","bugatti_centodieci","bugatti_galibier"));


        ImageView v1 = findViewById(R.id.advanced_level_image1);
        ImageView v2 = findViewById(R.id.advanced_level_image2);
        ImageView v3 = findViewById(R.id.advanced_level_image3);

        remainingTimeLabel = findViewById(R.id.remaining_time_label_ad);
        remainingTimeLabel.setVisibility(View.INVISIBLE);

        guess1 = findViewById(R.id.guess1);
        guess2 = findViewById(R.id.guess2);
        guess3 = findViewById(R.id.guess3);

        correctMake1 = findViewById(R.id.correct_answer1);
        correctMake2 = findViewById(R.id.correct_answer2);
        correctMake3 =findViewById(R.id.correct_answer3);

        nextButton = findViewById(R.id.submit_answer_button);
        resultMessage = findViewById(R.id.answer_result);
        remainingCount= findViewById(R.id.remaining_count);
        remainingCount.setText(String.valueOf(remainingAttempts));
        scoreCount = findViewById(R.id.score_count);
        countDownTimer3 = findViewById(R.id.countdown_timer3);

        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dfe39f"));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable);
        }

        // Getting the previous score of the game
        if (!storeTotalScore.isEmpty()){
            totalScore = storeTotalScore.get(0);
        }

        scoreCount.setText(String.valueOf(totalScore));

        while (true) {

            generateRandom();

            if (carListRandom == 0) {
                resource1 = toyotaCarList.get(randomNumber);
                carMake1 = "TOYOTA";
                if (!alreadyGuessedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource1);
                    break;
                }
                else {
                    continue;
                }
            }

            if (carListRandom == 1) {
                resource1 = nissanCarList.get(randomNumber);
                carMake1 = "NISSAN";
                if (!alreadyGuessedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource1);
                    break;
                }else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                resource1 = audiCarList.get(randomNumber);
                carMake1 = "AUDI";
                if (!alreadyGuessedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource1);
                    break;
                }else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                resource1 = hondaCarList.get(randomNumber);
                carMake1 = "HONDA";
                if (!alreadyGuessedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource1);

                    break;
                }else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                resource1 = bugattiCarList.get(randomNumber);
                carMake1 = "BUGATTI";
                if (!alreadyGuessedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource1);
                    break;
                }
                else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                resource1 = microCarList.get(randomNumber);
                carMake1 = "MICRO";
                if (!alreadyGuessedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource1);
                    break;
                }
            }
        }

        while (true) {
            generateRandom();

            if (carListRandom == 0) {
                resource2 = toyotaCarList.get(randomNumber);
                carMake2 = "TOYOTA";
                if (!alreadyGuessedCars.contains(resource2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource2);
                        break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 1) {
                resource2 = nissanCarList.get(randomNumber);
                carMake2 = "NISSAN";
                if (!alreadyGuessedCars.contains(resource2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource2);
                        break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                resource2 = audiCarList.get(randomNumber);
                carMake2 = "AUDI";
                if (!alreadyGuessedCars.contains(resource2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource2);
                        break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                resource2 = hondaCarList.get(randomNumber);
                carMake2 = "HONDA";
                if (!alreadyGuessedCars.contains(resource2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource2);
                        break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                resource2 = bugattiCarList.get(randomNumber);
                carMake2 = "BUGATTI";
                if (!alreadyGuessedCars.contains(resource2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource2);
                        break;
                } else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                resource2 = microCarList.get(randomNumber);
                carMake2 = "MICRO";
                if (!alreadyGuessedCars.contains(resource2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource2);
                        break;
                    }
            }
        }

        while (true) {
            generateRandom();

            if (carListRandom == 0) {
                resource3 = toyotaCarList.get(randomNumber);
                carMake3 = "TOYOTA";
                if (!alreadyGuessedCars.contains(resource3)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource3);
                    break;
                } else {
                    continue;
                }

            }

            if (carListRandom == 1) {
                resource3 = nissanCarList.get(randomNumber);
                carMake3 = "NISSAN";
                if (!alreadyGuessedCars.contains(resource3)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource3);
                    break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                resource3 = audiCarList.get(randomNumber);
                carMake3 = "AUDI";
                if (!alreadyGuessedCars.contains(resource3)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource3);
                    break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                resource3 = hondaCarList.get(randomNumber);
                carMake3 = "HONDA";
                if (!alreadyGuessedCars.contains(resource3)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource3);
                    break;
                } else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                resource3 = bugattiCarList.get(randomNumber);
                carMake3 = "BUGATTI";
                if (!alreadyGuessedCars.contains(resource3)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource3);
                    break;
                } else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                resource3 = microCarList.get(randomNumber);
                carMake3 = "MICRO";
                if (!alreadyGuessedCars.contains(resource3)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                    //Adding the current previewing image to a array list
                    alreadyGuessedCars.add(resource3);
                    break;
                    }
            }
        }

        //Starting countdown timer is the timer is switched on
        if (switchState){
            remainingTimeLabel.setVisibility(View.VISIBLE);
            startCountDown();
        }
    }

    //Generating a random number
    void generateRandom(){
        Random random = new Random();
        carListRandom = random.nextInt(6);
        randomNumber = random.nextInt(5);
    }

    void checkMake (){
        //Checking
        if (guess1.getText().toString().toUpperCase().equals(carMake1)){
            if (score1 == 0){
                score1 = 1;
                totalScore = score1 + score2 + score3;
                if (!storeTotalScore.isEmpty()){
                    totalScore = totalScore + storeTotalScore.get(0);
                }
            }
            guess1.setEnabled(false);
            guess1.setTextColor(Color.GREEN);
        }else {
            guess1.setTextColor(Color.RED);
        }
        if (guess2.getText().toString().toUpperCase().equals(carMake2)){
            if (score2 == 0){
                score2 = 1;
                totalScore = score1 + score2 + score3;
                if (!storeTotalScore.isEmpty()){
                    totalScore = totalScore + storeTotalScore.get(0);
                }
            }
            guess2.setEnabled(false);
            guess2.setTextColor(Color.GREEN);
        }else {
            guess2.setTextColor(Color.RED);
        }
        if (guess3.getText().toString().toUpperCase().equals(carMake3)){
            if (score3 == 0){
                score3 = 1;
                totalScore = score1 + score2 + score3;
                if (!storeTotalScore.isEmpty()){
                    totalScore = totalScore + storeTotalScore.get(0);
                }
            }
            guess3.setEnabled(false);
            guess3.setTextColor(Color.GREEN);
        }else {
            guess3.setTextColor(Color.RED);
        }
    }

    void checkAllCorrect(){
        if (guess1.getText().toString().toUpperCase().equals(carMake1) && guess2.getText().toString().toUpperCase().equals(carMake2) &&
                guess3.getText().toString().toUpperCase().equals(carMake3)) {
            resultMessage.setText(R.string.correct_message);
            resultMessage.setTextColor(Color.GREEN);
            resultMessage.setVisibility(View.VISIBLE);
            nextButton.setText(R.string.next_button);
        }else {
            remainingAttempts = remainingAttempts - 1;
            remainingCount.setText(String.valueOf(remainingAttempts));
            if (remainingAttempts == 0){
                nextButton.setText(R.string.next_button);
                resultMessage.setText(R.string.wrong_message);
                resultMessage.setTextColor(Color.RED);
                resultMessage.setVisibility(View.VISIBLE);

                if (!guess1.getText().toString().toUpperCase().equals(carMake1)){
                    correctMake1.setText(carMake1);
                    correctMake1.setTextColor(Color.YELLOW);
                    correctMake1.setVisibility(View.VISIBLE);
                }
                if (!guess2.getText().toString().toUpperCase().equals(carMake2)){
                    correctMake2.setText(carMake2);
                    correctMake2.setTextColor(Color.YELLOW);
                    correctMake2.setVisibility(View.VISIBLE);
                }
                if (!guess3.getText().toString().toUpperCase().equals(carMake3)){
                    correctMake3.setText(carMake3);
                    correctMake3.setTextColor(Color.YELLOW);
                    correctMake3.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void checkAnswers(View view) {
        if (nextButton.getText().toString().equals("NEXT")) {
            storeTotalScore.clear();
            storeTotalScore.add(totalScore);
            Intent refresh = getIntent();
            overridePendingTransition(0, 0);
            finish();
            startActivity(refresh);
            overridePendingTransition(0, 0);
        } else {
            checkMake();
            checkAllCorrect();
            scoreCount.setText(String.valueOf(totalScore));
        }

        if (alreadyGuessedCars.size() == 30 && remainingAttempts == 0){
            nextButton.setEnabled(false);
        }
    }

    void startCountDown() {
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (remainingAttempts !=0) {
                    countDownTimer3.setText(String.valueOf(countdown));
                    countdown--;
                }
            }

            @Override
            public void onFinish() {
                countDownTimer3.setText(String.valueOf(countdown));
                checkMake();
                checkAllCorrect();
                scoreCount.setText(String.valueOf(totalScore));
                if (remainingAttempts !=0){
                    countdown = 20;
                    startCountDown();
                }
            }
        }.start();
    }
}