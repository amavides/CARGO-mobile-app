package com.example.cardisplayapp;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.example.cardisplayapp.MainActivity.switchState;
public class RandomImageActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String[] carList = {"Select a car make","Toyota","Nissan", "Honda", "Audi", "Bugatti", "Micro"};
    public  String spinnerResponse,carImageResource;
    ArrayList<String> spinnerText = new ArrayList<>();
    ArrayList<String> toyotaCarList = new ArrayList<>();
    ArrayList<String> nissanCarList = new ArrayList<>();
    ArrayList<String> hondaCarList = new ArrayList<>();
    ArrayList<String> audiCarList = new ArrayList<>();
    ArrayList<String> microCarList = new ArrayList<>();
    ArrayList<String> bugattiCarList = new ArrayList<>();
    public static ArrayList<String> usedCarList= new ArrayList<>();
    TextView countDownTimer1, timeLeftLabel;
    int countdown = 20;
    CountDownTimer countDownTimer;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_image);

        //Adding the car makes to the spinner (dropdown)
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(RandomImageActivity.this,
                android.R.layout.simple_spinner_item, carList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, carList) {
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(this);

        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#dfe39f"));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable);
        }

        //Adding all the car image names to separate array lists based on their make
        toyotaCarList.addAll(Arrays.asList("toyota_fortuner", "toyota_yaris", "toyota_supra", "toyota_crown_de_luxe", "toyota_auris"));
        nissanCarList.addAll(Arrays.asList("nissan_murano", "nissan_leaf_2020", "nissan_navara", "nissan_gt_r", "nissan_altima"));
        hondaCarList.addAll(Arrays.asList("honda_civic", "honda_accord", "honda_fit", "honda_crv", "honda_acura_nsx"));
        audiCarList.addAll(Arrays.asList("audi_r8", "audi_a5", "audi_a6", "audi_a1", "audi_a3"));
        microCarList.addAll(Arrays.asList("micro_tivoli", "micro_baic_x25", "micro_geely_gc2", "micro_emgrand", "micro_panda"));
        bugattiCarList.addAll(Arrays.asList("bugatti_veyron", "bugatti_chiron", "bugatti_la_voiture_noire", "bugatti_centodieci", "bugatti_galibier"));

        ImageView v1 = findViewById(R.id.random_image);
        countDownTimer1 = findViewById(R.id.countdown_timer1);
        timeLeftLabel = findViewById(R.id.timeleft_label_random);
        countDownTimer1.setText(String.valueOf(countdown));
        countDownTimer1.setVisibility(View.INVISIBLE);
        timeLeftLabel.setVisibility(View.INVISIBLE);


        Random random = new Random();

        while (true) {

            //Generating random numbers to get a random make and random car
            int carListRandom = random.nextInt(6);
            int randomNumber = random.nextInt(5);

            //Getting a random toyota car
            if (carListRandom == 0) {
                    carImageResource = toyotaCarList.get(randomNumber);
                    //Getting a unique random car every time
                if (!usedCarList.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
                else {
                    continue;
                }
            }

            //Getting a random nissan car
            if (carListRandom == 1) {
                carImageResource = nissanCarList.get(randomNumber);
                //Getting a unique random car every time
                if (!usedCarList.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }else {
                    continue;
                }
            }

            //Getting a random audi car
            if (carListRandom == 2) {
                carImageResource = audiCarList.get(randomNumber);
                //Getting a unique random car every time
                if (!usedCarList.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
                else {
                    continue;
                }
            }

            //Getting a random honda car
            if (carListRandom == 3) {
                carImageResource = hondaCarList.get(randomNumber);
                //Getting a unique random car every time
                if (!usedCarList.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
                else {
                    continue;
                }
            }

            //Getting a random bugatti car
            if (carListRandom == 4) {
                carImageResource = bugattiCarList.get(randomNumber);
                //Getting a unique random car every time
                if (!usedCarList.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }else {
                    continue;
                }
            }

            //Getting a random micro car
            if (carListRandom == 5) {
                carImageResource = microCarList.get(randomNumber);
                //Getting a unique random car every time
                if (!usedCarList.contains(carImageResource)) {
                    int resource_id = getResources().getIdentifier(carImageResource,
                            "drawable", "com.example.cardisplayapp");
                    v1.setImageResource(resource_id);
                    break;
                }
            }
        }
        //Starting countdown timer if the timer is switched on
        if (switchState){
            timeLeftLabel.setVisibility(View.VISIBLE);
            countDownTimer1.setVisibility(View.VISIBLE);
            startCountDown();
        }

        //Adding the current previewing car to an array list to get unique car images every time
        usedCarList.add(carImageResource);
        System.out.println(usedCarList);
    }

    //When an item from the spinner(dropdown) is chosen
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerText.clear();
        spinnerResponse = parent.getItemAtPosition(position).toString();
        spinnerText.add(spinnerResponse);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void identify_Make(View view) {

        Button identify_Button = findViewById(R.id.submit_button);

        //When the identify button becomes the next button advancing to the next screen
        if (identify_Button.getText().equals("NEXT")) {
            if (usedCarList.size() != 30) {
                //Restarting the current intent without any transition effect
                Intent refresh = getIntent();
                overridePendingTransition(0, 0);
                finish();
                startActivity(refresh);
                overridePendingTransition(0, 0);
            }
        } else {
            checkResult();
        }
    }

    //Checking user input spinner item is correct or wrong
        void checkResult(){
            Button identify_Button = findViewById(R.id.submit_button);

            TextView message = findViewById(R.id.resultview_random);
            TextView correctCarMessage = findViewById(R.id.correct_answer_random);
            correctCarMessage.setTextColor(Color.YELLOW);

            switch (spinnerResponse) {
                /*Checking if the spinner selected value is equal to which make.If the answer is correct
                displaying correct message in green color. If not displaying wrong message in red color along with the
                correct car make name in yellow color
                 */
                case "Toyota":
                    if (toyotaCarList.contains(carImageResource)) {
                        message.setText(R.string.correct_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.GREEN);
                    } else {
                        message.setText(R.string.wrong_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.RED);

                        correctCarMessage.setVisibility(TextView.VISIBLE);

                        if (nissanCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.nissan_label);
                        }

                        if (audiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.audi_label);
                        }

                        if (bugattiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.bugatti_label);
                        }

                        if (microCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.micro_label);
                        }
                        if (hondaCarList.contains(carImageResource)){
                            correctCarMessage.setText(R.string.honda_label);
                        }
                    }
                    break;

                case "Nissan":
                    if (nissanCarList.contains(carImageResource)) {
                        message.setText(R.string.correct_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.GREEN);
                    } else {
                        message.setText(R.string.wrong_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.RED);

                        correctCarMessage.setVisibility(TextView.VISIBLE);

                        if (toyotaCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.toyota_label);
                        }

                        if (audiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.audi_label);
                        }

                        if (bugattiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.bugatti_label);
                        }

                        if (microCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.micro_label);
                        }

                        if (hondaCarList.contains(carImageResource)){
                            correctCarMessage.setText(R.string.honda_label);
                        }
                    }
                    break;

                case "Audi":
                    if (audiCarList.contains(carImageResource)) {
                        message.setText(R.string.correct_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.GREEN);
                    } else {
                        message.setText(R.string.wrong_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.RED);

                        correctCarMessage.setVisibility(TextView.VISIBLE);

                        if (toyotaCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.toyota_label);
                        }

                        if (nissanCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.nissan_label);
                        }

                        if (bugattiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.bugatti_label);
                        }

                        if (microCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.micro_label);
                        }

                        if (hondaCarList.contains(carImageResource)){
                            correctCarMessage.setText(R.string.honda_label);
                        }
                    }
                    break;

                case "Bugatti":
                    if (bugattiCarList.contains(carImageResource)) {
                        message.setText(R.string.correct_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.GREEN);
                    } else {
                        message.setText(R.string.wrong_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.RED);

                        correctCarMessage.setVisibility(TextView.VISIBLE);

                        if (nissanCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.nissan_label);
                        }

                        if (audiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.audi_label);
                        }

                        if (toyotaCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.toyota_label);
                        }

                        if (microCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.micro_label);
                        }

                        if (hondaCarList.contains(carImageResource)){
                            correctCarMessage.setText(R.string.honda_label);
                        }
                    }
                    break;

                case "Micro":
                    if (microCarList.contains(carImageResource)) {
                        message.setText(R.string.correct_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.GREEN);
                    } else {
                        message.setText(R.string.wrong_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.RED);

                        correctCarMessage.setVisibility(TextView.VISIBLE);

                        if (nissanCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.nissan_label);
                        }

                        if (audiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.audi_label);
                        }

                        if (bugattiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.bugatti_label);
                        }

                        if (toyotaCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.toyota_label);
                        }

                        if (hondaCarList.contains(carImageResource)){
                            correctCarMessage.setText(R.string.honda_label);
                        }
                    }
                    break;

                case "Honda":
                    if (hondaCarList.contains(carImageResource)) {
                        message.setText(R.string.correct_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.GREEN);
                    } else {
                        message.setText(R.string.wrong_message);
                        message.setVisibility(TextView.VISIBLE);
                        message.setTextColor(Color.RED);

                        correctCarMessage.setVisibility(TextView.VISIBLE);

                        if (nissanCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.nissan_label);
                        }

                        if (audiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.audi_label);
                        }

                        if (bugattiCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.bugatti_label);
                        }

                        if (toyotaCarList.contains(carImageResource)) {
                            correctCarMessage.setText(R.string.toyota_label);
                        }

                        if (microCarList.contains(carImageResource)){
                            correctCarMessage.setText(R.string.micro_label);
                        }
                    }
                    break;

                    //If none of the makes are selected by the user
                default:
                    message.setText(R.string.no_make_selected);
                    message.setVisibility(TextView.VISIBLE);
                    message.setTextColor(Color.RED);
            }
            //When user has selected a car make
            if (!spinnerResponse.equals("Select a car make")) {
                identify_Button.setText(R.string.next_button);
                //If the countdown timer ends
            }else if (countdown == 0){
                identify_Button.setText(R.string.next_button);
                message.setText(R.string.wrong_message);
                message.setVisibility(TextView.VISIBLE);
                message.setTextColor(Color.RED);
                if (nissanCarList.contains(carImageResource)) {
                    correctCarMessage.setText(R.string.nissan_label);
                }

                if (audiCarList.contains(carImageResource)) {
                    correctCarMessage.setText(R.string.audi_label);
                }

                if (bugattiCarList.contains(carImageResource)) {
                    correctCarMessage.setText(R.string.bugatti_label);
                }

                if (toyotaCarList.contains(carImageResource)) {
                    correctCarMessage.setText(R.string.toyota_label);
                }

                if (hondaCarList.contains(carImageResource)){
                    correctCarMessage.setText(R.string.honda_label);
                }
                if (microCarList.contains(carImageResource)){
                    correctCarMessage.setText(R.string.micro_label);
                }
                correctCarMessage.setVisibility(View.VISIBLE);
            }
        }

        //Creating the countdown timer of 20 seconds
    void startCountDown(){
             countDownTimer = new CountDownTimer(20000,1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    countDownTimer1.setText(String.valueOf(countdown));
                    // Decreasing countdown second by second
                    countdown --;
                }

                @Override
                public void onFinish() {
                    countDownTimer1.setText(String.valueOf(countdown));
                    //Checking results after countdown finishes
                    checkResult();
                }
            }.start();
    }
}