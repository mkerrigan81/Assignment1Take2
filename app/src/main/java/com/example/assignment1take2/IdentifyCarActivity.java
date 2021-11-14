package com.example.assignment1take2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdentifyCarActivity extends MainActivity {
    //Setting variables for three images
    ImageView image1;
    ImageView image2;
    ImageView image3;
    //Variables for the 2 different buttons
    Button btnDisplay;
    Button btnNext;
    //Variables for
    TextView txtRandomBrand;
    int randomNum = 0;
    String textBrand;
    String brand;
    String selectedImage;
    String selectedImage2;
    String selectedImage3;
    String selectedImage1;
    TextView txtCounter;
    Boolean startBrandTimer = false;
    CountDownTimer countDownTimer;
    int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car);

        //Initialising variables
        image1 = (ImageView) findViewById(R.id.imgCar1);
        image2 = (ImageView) findViewById(R.id.imgCar2);
        image3 = (ImageView) findViewById(R.id.imgCar3);
        btnDisplay = (Button) findViewById(R.id.btnDisplayedBrandName);
        btnNext = (Button) findViewById(R.id.btnNext2);
        btnNext.setVisibility(View.GONE);
        txtRandomBrand = (TextView) findViewById(R.id.txtRandomBrand);

        //Call randomImages() function onCreate
        randomImages();
        //Call startCountDownTimer() function onCreate
        startCountDownTimer();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //When btnNext is clicked, make the Display button visible and Next button invisible
                btnDisplay.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.GONE);

                txtRandomBrand.setText(brand);
                textBrand = txtRandomBrand.getText().toString();
                //Calling the randomImages() function again when the Next button is clicked so more random images
                //are displayed
                randomImages();

                //Resetting the counter to 10 and restarting the countDownTimer
                counter = 10;
                startCountDownTimer();
            }
        });
    }

    protected void startCountDownTimer(){

        startBrandTimer = getIntent().getBooleanExtra("car_key", startTimer);
        //These variables are for the countDownTimer feature.
        txtCounter = (TextView) findViewById(R.id.txtCounter);
        //Setting the value of our startBrandTimer to the value of the intent from the MainActivity

        //Then if startBrandTimer equals true, we are going to start our countDownTimer
        if(startBrandTimer){
            countDownTimer = new CountDownTimer(10000, 1000) {
                public void onTick(long millisUntilFinished) {
                    txtCounter.setText(String.valueOf(counter));
                    if (counter > 1 && counter < 10000){
                        counter--;
                    }
                }
                public void onFinish() {
                    Toast toast = new Toast(getApplicationContext());
                    TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.RED);tv.setTextSize(30);tv.setText("WRONG! ");toast.setView(tv);toast.show();
                    btnNext.setVisibility(View.VISIBLE);
                    btnDisplay.setVisibility(View.GONE);
                }
            }.start();
        }
    }

    public void stopCountDownTimer(){
        if (countDownTimer != null){
            countDownTimer.cancel();
            txtCounter.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onStop() {
        stopCountDownTimer();
        super.onStop();
    }


    public void randomImages() {
        //Creating an ArrayList with the 10 different brand types (folders)
        ArrayList<String> brands = new ArrayList<String>(10);
        brands.add("Audi");
        brands.add("Bentley");
        brands.add("BMW");
        brands.add("Fiat");
        brands.add("Ford");
        brands.add("Honda");
        brands.add("Hyundai");
        brands.add("Jaguar");
        brands.add("Toyota");
        brands.add("Mercedes");

        //Creating an ArrayList for brands whose image has already been used
        ArrayList<String> usedBrands = new ArrayList<>();

        //Creating the first random number which will loop through the brands array
        //and pull out a brand whose position is equal to the random number
        Random random = new Random();
        brand = brands.get(random.nextInt(10));
        //Using a while loop so that while the brand is already used (in the usedBrands array)
        //another brand will be picked out
        while (usedBrands.contains(brand)) {
            brand = brands.get(random.nextInt(10));
        }
        //If the brand hasn't already been used, we're adding the brand chosen to the usedBrand array
        //as it has now been used
        usedBrands.add(brand);
        //Generating a new random number between 1-10
        Random random2 = new Random();
        randomNum = random2.nextInt(10) + 1;
        //We will append the brand variable and the randomNum onto the filepath string
        //this is picking out a car between 1 & 10 from the folder
        String fileNameCar = "/sdcard/Images/Images/" + brand + "/car_" + randomNum + ".jpg";
        //We are then setting that image to the bitmap
        Bitmap bitmap = BitmapFactory.decodeFile(fileNameCar);
        image1.setImageBitmap(bitmap);
        selectedImage1 = fileNameCar;

        /*This is the code behind generating a second image different from the first*/
        Random random3 = new Random();
        brand = brands.get(random3.nextInt(10));
        while (usedBrands.contains(brand)) {
            brand = brands.get(random.nextInt(10));
        }
        usedBrands.add(brand);
        Random random4 = new Random();
        randomNum = random4.nextInt(10) + 1;
        String fileNameCar2 = "/sdcard/Images/Images/" + brand + "/car_" + randomNum + ".jpg";
        Bitmap bitmap2 = BitmapFactory.decodeFile(fileNameCar2);
        image2.setImageBitmap(bitmap2);
        selectedImage2 = fileNameCar2;

        /*This is the code behind generating a third image different from the first and second*/
        Random random5 = new Random();
        brand = brands.get(random5.nextInt(10));
        while (usedBrands.contains(brand)) {
            brand = brands.get(random.nextInt(10));
        }
        usedBrands.add(brand);
        Random random6 = new Random();
        randomNum = random6.nextInt(10) + 1;
        String fileNameCar3 = "/sdcard/Images/Images/" + brand + "/car_" + randomNum + ".jpg";
        Bitmap bitmap3 = BitmapFactory.decodeFile(fileNameCar3);
        image3.setImageBitmap(bitmap3);
        selectedImage3 = fileNameCar3;

        //Here I am creating another random number which is going to be used to loop through the usedBrands array
        //and it is then setting it to the selectedImage1 variable
        Random randomGuess = new Random();
        selectedImage = usedBrands.get(random.nextInt(3));
        //From here I am setting the text of txtRandom brand to selectedImage1
        //and then putting that text into the textBrand TextView
        txtRandomBrand.setText(selectedImage);
        textBrand = txtRandomBrand.getText().toString();
    }


    //Code for when the user clicks the third image
    public void image1Click(View view) {
        //This code checks if the selectedImage name contains the same name as the Brand
        if (selectedImage1.contains("Audi") && textBrand.contains("Audi")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Bentley") && textBrand.contains("Bentley")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("BMW") && textBrand.contains("BMW")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Fiat") && textBrand.contains("Fiat")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Ford") && textBrand.contains("Ford")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Honda") && textBrand.contains("Honda")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Hyundai") && textBrand.contains("Hyundai")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Jaguar") && textBrand.contains("Jaguar")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Mercedes") && textBrand.contains("Mercedes")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage1.contains("Toyota") && textBrand.contains("Toyota")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.RED);tv.setTextSize(30);tv.setText("WRONG! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        }
    }

    //Code for when the user clicks the second image
    public void image2Click(View view) {
        //This code checks if the selectedImage name contains the same name as the Brand
        if (selectedImage2.contains("Audi") && textBrand.contains("Audi")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Bentley") && textBrand.contains("Bentley")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("BMW") && textBrand.contains("BMW")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Fiat") && textBrand.contains("Fiat")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Ford") && textBrand.contains("Ford")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Honda") && textBrand.contains("Honda")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Hyundai") && textBrand.contains("Hyundai")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Jaguar") && textBrand.contains("Jaguar")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Mercedes") && textBrand.contains("Mercedes")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage2.contains("Toyota") && textBrand.contains("Toyota")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);

        } else {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.RED);tv.setTextSize(30);tv.setText("WRONG! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        }
    }

    //Code for when the user clicks the third image
    public void image3Click(View view) {

        //This code checks if the selectedImage name contains the same name as the Brand
        if (selectedImage3.contains("Audi") && textBrand.contains("Audi")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Bentley") && textBrand.contains("Bentley")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("BMW") && textBrand.contains("BMW")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Fiat") && textBrand.contains("Fiat")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Ford") && textBrand.contains("Ford")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Honda") && textBrand.contains("Honda")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Hyundai") && textBrand.contains("Hyundai")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Jaguar") && textBrand.contains("Jaguar")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Mercedes") && textBrand.contains("Mercedes")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        } else if (selectedImage3.contains("Toyota") && textBrand.contains("Toyota")) {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.GREEN);tv.setTextSize(30);tv.setText("CORRECT! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);

        } else {
            Toast toast = new Toast(getApplicationContext());
            TextView tv = new TextView(IdentifyCarActivity.this);tv.setBackgroundColor(Color.RED);tv.setTextSize(30);tv.setText("WRONG! ");toast.setView(tv);toast.show();
            btnNext.setVisibility(View.VISIBLE);
            btnDisplay.setVisibility(View.GONE);
        }
    }
}

