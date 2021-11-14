package com.example.assignment1take2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Keyframe;
import android.app.Notification;
import android.content.Context;
import android.media.Image;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Duration;
import java.util.Random;
import java.util.Timer;

public class SearchBrands extends AppCompatActivity {
    //Setting my variables for the activity
    Button btnSubmit;
    Button btnStop;
    TextView txtSearchBrands;
    int imageNumber = 0;
    ImageView imageView2;
    protected String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_brands);
        btnSubmit = (Button)findViewById(R.id.btnSubmitSearch);
        btnStop = (Button)findViewById(R.id.btnStopSearch);
        txtSearchBrands = (TextView)findViewById(R.id.txtSearchBox);
        imageView2 = (ImageView)findViewById(R.id.imageView2);


        //Creating new CountDownTimer which counts down from 3 seconds
        CountDownTimer countDownTimer = new CountDownTimer(3000, 3000) {

            public void onTick(long millisUntilFinished) {
                //The onTick of the CountDownTimer calls the generateRandomImage function which I've created below
                generateRandomImage();
            }

            public void onFinish() {
                //The onFinish of the CountDownTimer restarts the timer
                start();
            }
        };

        //Actions to complete when Submit button is clicked
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //When the Submit button is clicked the timer starts
                    countDownTimer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When the Stop button is clicked the timer stops
                countDownTimer.cancel();
            }
        });
    }

    public void generateRandomImage(){
        //Function to create random image

        if (txtSearchBrands.getText().toString().equals("Audi")){
            //If the user enters Audi, the system generates a number between 1-10 and appends that number onto
            //the end of a string which contains our drawable image
            Random random = new Random();
            imageNumber = random.nextInt(10) + 1;
            System.out.println("Audi");
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
        }

        else if (txtSearchBrands.getText().toString().equals("Bentley")){
            //For the rest of the brands, I had to create a random number between a specific range. For example, Bentley is car11 > car20
            //so I had to generate a number between 11 and 20
            Random random = new Random();
            int low = 11;
            int high = 20;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Bentley");
        }
        else if (txtSearchBrands.getText().toString().equals("BMW")){
            Random random = new Random();
            int low = 21;
            int high = 30;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("BMW");
        }
        else if (txtSearchBrands.getText().toString().equals("Fiat")){
            Random random = new Random();
            int low = 31;
            int high = 40;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Fiat");
        }
        else if (txtSearchBrands.getText().toString().equals("Ford")){
            Random random = new Random();
            int low = 41;
            int high = 50;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Ford");
        }
        else if (txtSearchBrands.getText().toString().equals("Honda")){
            Random random = new Random();
            int low = 51;
            int high = 60;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Honda");
        }
        else if (txtSearchBrands.getText().toString().equals("Hyundai")){
            Random random = new Random();
            int low = 61;
            int high = 70;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Hyundai");
        }
        else if (txtSearchBrands.getText().toString().equals("Jaguar")){
            Random random = new Random();
            int low = 71;
            int high = 80;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Jaguar");
        }
        else if (txtSearchBrands.getText().toString().equals("Mercedes")){
            Random random = new Random();
            int low = 81;
            int high = 90;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Mercedes");
        }
        else if (txtSearchBrands.getText().toString().equals("Toyota")){
            Random random = new Random();
            int low = 91;
            int high = 100;
            imageNumber = random.nextInt(high - low) + low;
            str = "car_" + imageNumber;
            imageView2.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
            System.out.println("Toyota");
        }
    }

    //Creating a resource id which will be used to populate the imageView
    protected final static int getResourceID (final String resName, final String resType, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0){
            throw new IllegalArgumentException(
                    "No resource string found with name " + resName
            );
        }
        else{

            return ResourceID;
        }
    }
}