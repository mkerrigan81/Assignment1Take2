package com.example.assignment1take2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch toggleSwitch;
    Boolean startTimer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleSwitch = (Switch) findViewById(R.id.toggleSwitch);
    }

    //This method will be used to store the value of the toggleSwitch in an intent so we
    //can pass the data onto the next activity
    private void send_data_brand(){
        startTimer = toggleSwitch.isChecked();
        Intent i = new Intent(getBaseContext(), IdentifyBrandActivity.class);
        i.putExtra("key", startTimer);
        startActivity(i);
    }

    private void send_data_car(){
        startTimer = toggleSwitch.isChecked();
        Intent j = new Intent(getBaseContext(), IdentifyCarActivity.class);
        j.putExtra("car_key", startTimer);
        startActivity(j);
    }

    //Creating a method so that when the Identify Brand button is clicked we move to that activity
    public void goIdentifyBrand(View view){
        send_data_brand();
    }

    //Creating a method so that when the Identify Car button is clicked we move to that activity
    public void goIdentifyCar(View view){
        send_data_car();
    }

    //Creating a method so that when the Search Brand button is clicked we move to that activity
    public void goSearchBrands(View view){
        startActivity(new Intent(MainActivity.this, SearchBrands.class));
    }
}