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
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.example.cardisplayapp.MainActivity.switchState;

public class ClickableImageActivity extends AppCompatActivity {

    public String randomResource;
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
    public static ArrayList<String> alreadyUsedCars = new ArrayList<>();
    int carListRandom;
    int randomNumber;
    TextView resultMessage;
    Button nextButton;
    TextView countDownTimer3, timeLeftLabel;
    int countdown = 20;
    CountDownTimer countDownTimer;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable_image);

        toyotaCarList.addAll(Arrays.asList("toyota_fortuner","toyota_yaris", "toyota_supra", "toyota_crown_de_luxe", "toyota_auris"));
        nissanCarList.addAll(Arrays.asList("nissan_murano","nissan_leaf_2020","nissan_navara","nissan_gt_r","nissan_altima"));
        hondaCarList.addAll(Arrays.asList("honda_civic","honda_accord","honda_fit","honda_crv","honda_acura_nsx"));
        audiCarList.addAll(Arrays.asList("audi_r8","audi_a5","audi_a6","audi_a1","audi_a3"));
        microCarList.addAll(Arrays.asList("micro_tivoli","micro_baic_x25","micro_geely_gc2","micro_emgrand","micro_panda"));
        bugattiCarList.addAll(Arrays.asList("bugatti_veyron","bugatti_chiron","bugatti_la_voiture_noire","bugatti_centodieci","bugatti_galibier"));


        ImageView v1 = findViewById(R.id.imageView2);
        ImageView v2 = findViewById(R.id.imageView3);
        ImageView v3 = findViewById(R.id.imageView4);

        nextButton = findViewById(R.id.next_screen_button);
        nextButton.setEnabled(false);
        countDownTimer3 = findViewById(R.id.countdown_timer3);
        resultMessage = findViewById(R.id.answerView);
        resultMessage.setVisibility(View.INVISIBLE);
        timeLeftLabel = findViewById(R.id.timeleft_label);
        timeLeftLabel.setVisibility(View.INVISIBLE);

        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dfe39f"));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable);
        }

        while (true) {

            generateRandom();

            if (carListRandom == 0) {
                resource1 = toyotaCarList.get(randomNumber);
                carMake1 = "TOYOTA";
                //Getting a unique car
                if (!alreadyUsedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
                else {
                    continue;
                }
            }

            if (carListRandom == 1) {
                resource1 = nissanCarList.get(randomNumber);
                carMake1 = "NISSAN";
                //Getting a unique car
                if (!alreadyUsedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                resource1 = audiCarList.get(randomNumber);
                carMake1 = "AUDI";
                //Getting a unique car
                if (!alreadyUsedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                resource1 = hondaCarList.get(randomNumber);
                carMake1 = "HONDA";
                //Getting a unique car
                if (!alreadyUsedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);

                    break;
                }else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                resource1 = bugattiCarList.get(randomNumber);
                carMake1 = "BUGATTI";
                //Getting a unique car
                if (!alreadyUsedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
                else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                resource1 = microCarList.get(randomNumber);
                carMake1 = "MICRO";
                //Getting a unique car
                if (!alreadyUsedCars.contains(resource1)) {
                    int resource_id = getResources().getIdentifier(resource1,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
            }
        }

        while (true) {
            generateRandom();

            if (carListRandom == 0) {
                resource2 = toyotaCarList.get(randomNumber);
                carMake2 = "TOYOTA";
                //Getting a unique car with a different make from the first
                if (!alreadyUsedCars.contains(resource2)) {
                    if (!carMake1.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 1) {
                resource2 = nissanCarList.get(randomNumber);
                carMake2 = "NISSAN";
                //Getting a unique car with a different make from the first
                if (!alreadyUsedCars.contains(resource2)) {
                    if (!carMake1.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                resource2 = audiCarList.get(randomNumber);
                carMake2 = "AUDI";
                //Getting a unique car with a different make from the first
                if (!alreadyUsedCars.contains(resource2)) {
                    if (!carMake1.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                resource2 = hondaCarList.get(randomNumber);
                carMake2 = "HONDA";
                //Getting a unique car with a different make from the first
                if (!alreadyUsedCars.contains(resource2)) {
                    if (!carMake1.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                resource2 = bugattiCarList.get(randomNumber);
                carMake2 = "BUGATTI";
                //Getting a unique car with a different make from the first
                if (!alreadyUsedCars.contains(resource2)) {
                    if (!carMake1.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                resource2 = microCarList.get(randomNumber);
                carMake2 = "MICRO";
                //Getting a unique car with a different make from the first
                if (!alreadyUsedCars.contains(resource2)) {
                    if (!carMake1.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource2,
                                "drawable", "com.example.cardisplayapp");
                        v2.setImageResource(resource_id);
                        break;
                    }
                }
            }
        }

        while (true) {
            generateRandom();

            if (carListRandom == 0) {
                resource3 = toyotaCarList.get(randomNumber);
                carMake3 = "TOYOTA";
                //Getting a unique car with a different make from first and second
                if (!alreadyUsedCars.contains(resource3)) {
                    if (!carMake3.equals(carMake1) && !carMake3.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }

            }

            if (carListRandom == 1) {
                resource3 = nissanCarList.get(randomNumber);
                carMake3 = "NISSAN";
                //Getting a unique car with a different make from first and second
                if (!alreadyUsedCars.contains(resource3)) {
                    if (!carMake3.equals(carMake1) && !carMake3.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 2) {
                resource3 = audiCarList.get(randomNumber);
                carMake3 = "AUDI";
                //Getting a unique car with a different make from first and second
                if (!alreadyUsedCars.contains(resource3)) {
                    if (!carMake3.equals(carMake1) && !carMake3.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 3) {
                resource3 = hondaCarList.get(randomNumber);
                carMake3 = "HONDA";
                //Getting a unique car with a different make from first and second
                if (!alreadyUsedCars.contains(resource3)) {
                    if (!carMake3.equals(carMake1) && !carMake3.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }

            if (carListRandom == 4) {
                resource3 = bugattiCarList.get(randomNumber);
                carMake3 = "BUGATTI";
                //Getting a unique car with a different make from first and second
                if (!alreadyUsedCars.contains(resource3)) {
                    if (!carMake3.equals(carMake1) && !carMake3.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (carListRandom == 5) {
                resource3 = microCarList.get(randomNumber);
                carMake3 = "MICRO";
                //Getting a unique car with a different make from first and second
                if (!alreadyUsedCars.contains(resource3)) {
                    if (!carMake3.equals(carMake1) && !carMake3.equals(carMake2)) {
                        int resource_id = getResources().getIdentifier(resource3,
                                "drawable", "com.example.cardisplayapp");
                        v3.setImageResource(resource_id);
                        break;
                    }
                }
            }
        }
        //Adding the current cars to a single array list to get unique cars every time
        alreadyUsedCars.add(resource1);
        alreadyUsedCars.add(resource2);
        alreadyUsedCars.add(resource3);

        //Disabling the next button if all the 30 cars have been shown
        if (alreadyUsedCars.size() == 30){
            nextButton.setEnabled(false);
        }
        randomMakeSelection();
        if (switchState){
            startCountDown();
        }
    }

    //Generating a random number
    void generateRandom(){
        Random random = new Random();
        carListRandom = random.nextInt(6);
        randomNumber = random.nextInt(5);
    }

    //Selecting a random car make for guessing
    void randomMakeSelection(){
        TextView random_make = findViewById(R.id.textView5);
        Random random = new Random();
        int make_random = random.nextInt(3);

        if (make_random == 0){
            randomResource = resource1;
        }

        else if (make_random==1){
            randomResource = resource2;
        }

        else if (make_random==2){
            randomResource = resource3;
        }

        if (toyotaCarList.contains(randomResource)){
            random_make.setText(R.string.toyota_label);
        }

        if (nissanCarList.contains(randomResource)){
            random_make.setText(R.string.nissan_label);
        }
        if (audiCarList.contains(randomResource)){
            random_make.setText(R.string.audi_label);
        }
        if (hondaCarList.contains(randomResource)){
            random_make.setText(R.string.honda_label);
        }
        if (microCarList.contains(randomResource)){
            random_make.setText(R.string.micro_label);
        }
        if (bugattiCarList.contains(randomResource)){
            random_make.setText(R.string.bugatti_label);
        }
    }

    //Checking if the user clicked image for the make is correct or not
    public void identifyImage1(View view) {
        resultMessage = findViewById(R.id.answerView);

        if (resultMessage.getText().toString().equals("TextView")) {
            if (resource1.equals(randomResource)) {
                resultMessage.setTextColor(Color.GREEN);
                resultMessage.setText(R.string.correct_message);
            } else {
                resultMessage.setTextColor(Color.RED);
                resultMessage.setText(R.string.wrong_message);
            }
            resultMessage.setVisibility(View.VISIBLE);
            if (alreadyUsedCars.size() != 30) {
                nextButton.setEnabled(true);
            }
        }
    }

    //Checking if the user clicked image for the make is correct or not
    public void identifyImage2(View view) {
        resultMessage = findViewById(R.id.answerView);

        if (resultMessage.getText().toString().equals("TextView")) {
            if (resource2.equals(randomResource)) {
                resultMessage.setTextColor(Color.GREEN);
                resultMessage.setText(R.string.correct_message);
            } else {
                resultMessage.setTextColor(Color.RED);
                resultMessage.setText(R.string.wrong_message);
            }
            resultMessage.setVisibility(View.VISIBLE);
            if (alreadyUsedCars.size() != 30) {
                nextButton.setEnabled(true);
            }
        }
    }

    //Checking if the user clicked image for the make is correct or not
    public void identifyImage3(View view) {

        resultMessage = findViewById(R.id.answerView);
        if (resultMessage.getText().toString().equals("TextView")) {

            if (resource3.equals(randomResource)) {
                resultMessage.setTextColor(Color.GREEN);
                resultMessage.setText(R.string.correct_message);
            } else {
                resultMessage.setTextColor(Color.RED);
                resultMessage.setText(R.string.wrong_message);
            }
            resultMessage.setVisibility(View.VISIBLE);
            if (alreadyUsedCars.size() != 30) {
                nextButton.setEnabled(true);
            }
        }
    }

    //Advancing to the next screen
    public void nextScreen(View view) {
        if (nextButton.getText().toString().equals("Next")) {
            Intent refresh = getIntent();
            overridePendingTransition(0, 0);
            finish();
            startActivity(refresh);
            overridePendingTransition(0, 0);
        }
    }

    //Starting the countdown timer
    void startCountDown(){
        timeLeftLabel.setVisibility(View.VISIBLE);
        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDownTimer3.setText(String.valueOf(countdown));
                countdown --;
            }

            @Override
            public void onFinish() {
                countDownTimer3.setText(String.valueOf(countdown));
                resultMessage = findViewById(R.id.answerView);
                if (resultMessage.getText().toString().equals("TextView")) {
                    resultMessage.setTextColor(Color.RED);
                    resultMessage.setText(R.string.wrong_message);
                    resultMessage.setVisibility(View.VISIBLE);
                    if (alreadyUsedCars.size() != 30) {
                        nextButton.setEnabled(true);
                    }
                }
            }
        }.start();
    }
}