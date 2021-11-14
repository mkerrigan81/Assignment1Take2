package com.example.assignment1take2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IdentifyBrandActivity extends MainActivity {

    protected ImageView imageView;
    protected String str;
    Button btnSubmit;
    Button btnNext;
    Spinner spinnerBrand;
    int imageNumber = 0;
    int counter = 10;
    TextView textView;
    long mTimeLeftInMillis;
    boolean mTimerRunning = false;
    boolean startBrandTimer = false;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_brand);
        imageView = (ImageView)findViewById(R.id.imageView);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnNext = (Button)findViewById(R.id.btnNext);
        //Setting Next button to invisible until the user guesses correctly
        btnNext.setVisibility(View.GONE);
        spinnerBrand = (Spinner)findViewById(R.id.spinnerBrnd);

        //Creating new random variable which is going to loop through 100 numbers
        //each number represents one of the cars
        Random rnd = new Random();
        imageNumber = rnd.nextInt(100)+1;
        System.out.println("imageNumber = " + imageNumber);
        str = "car_" + imageNumber;
        imageView.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));

        //Creating string array to get my string array "brands"
        String[] brands = getResources().getStringArray(R.array.brands);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, brands);
        //Populating items from array into Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBrand.setAdapter(adapter);

        startCountDownTimer();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This If Statement is used to check if the random number (1-100) is between certain value
                //If the random number is between a certain value, and the item from the Spinner equals a certain value
                //it determines if the users guess is correct or not

                if (imageNumber <=10 && spinnerBrand.getSelectedItem().equals("Audi")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this); tv.setBackgroundColor(Color.GREEN); tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 10 && imageNumber <= 20 && spinnerBrand.getSelectedItem().equals("Bentley")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }
                else if (imageNumber > 20 && imageNumber <= 30 && spinnerBrand.getSelectedItem().equals("BMW")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 30 && imageNumber <= 40 && spinnerBrand.getSelectedItem().equals("Fiat")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 40 && imageNumber <= 50 && spinnerBrand.getSelectedItem().equals("Ford")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 50 && imageNumber <= 60 && spinnerBrand.getSelectedItem().equals("Honda")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 60 && imageNumber <= 70 && spinnerBrand.getSelectedItem().equals("Hyundai")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 70 && imageNumber <= 80 && spinnerBrand.getSelectedItem().equals("Jaguar")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 80 && imageNumber <= 90 && spinnerBrand.getSelectedItem().equals("Mercedes")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }

                else if (imageNumber > 90 && imageNumber <= 100 && spinnerBrand.getSelectedItem().equals("Toyota")){
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);

                }else{
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyBrandActivity.this);tv.setBackgroundColor(Color.RED);tv.setTextSize(30);tv.setText("WRONG! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.GONE);
                }
            }
        });

        //Creating on click listener for the Next button
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Once the Next button is clicked, the Submit button becomes visible to the user again
                //and the Next button becomes invisible again
                btnSubmit.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.GONE);
                //Resetting spinner to Please Select
                spinnerBrand.setSelection(0);

                //Generating a new random number to get a different image once the next button has been clicked
                Random rnd = new Random();
                imageNumber = rnd.nextInt(100)+1;
                System.out.println("imageNumber = " + imageNumber);
                str = "car_" + imageNumber;
                imageView.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));

                counter = 10;
                startCountDownTimer();
            }
        });
    }

    protected void startCountDownTimer(){

        startBrandTimer = getIntent().getBooleanExtra("key", startTimer);
        //These variables are for the countDownTimer feature.
        textView = (TextView) findViewById(R.id.txtCountdownTimer);
        //Setting the value of our startBrandTimer to the value of the intent from the MainActivity

        //Then if startBrandTimer equals true, we are going to start our countDownTimer
        if(startBrandTimer){
                countDownTimer = new CountDownTimer(10000, 1000) {
                public void onTick(long millisUntilFinished) {
                    /*mTimeLeftInMillis = millisUntilFinished;*/
                    textView.setText(String.valueOf(counter));
                    if (counter > 1 && counter < 10000){
                        counter--;
                    }
                }
                public void onFinish() {
                    btnSubmit.callOnClick();
                }
            }.start();
            mTimerRunning = true;
        }
    }

    public void stopCountDownTimer(){
        if (countDownTimer != null){
            countDownTimer.cancel();
            textView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onStop() {
        stopCountDownTimer();
        super.onStop();
    }

    //Creating a resource id which will be used to populate the imageView
    protected final static int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0){
            throw new IllegalArgumentException("No resource string found with name " + resName);
        }
        else{
            return ResourceID;
        }
    }

    //When the screen rotates, I'm saving the image and integer from the screen before
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("param", str);
        savedInstanceState.putInt("count", imageNumber);

        savedInstanceState.putInt("counter", counter);
        savedInstanceState.putLong("timeLeft", mTimeLeftInMillis);
        savedInstanceState.putBoolean("timerRunning", mTimerRunning);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        str = savedInstanceState.getString("param");
        imageNumber = savedInstanceState.getInt("count");
        imageView.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));

        counter = savedInstanceState.getInt("counter");
        mTimeLeftInMillis = savedInstanceState.getLong("timeLeft");
        mTimerRunning = savedInstanceState.getBoolean("timerRunning");
    }
}