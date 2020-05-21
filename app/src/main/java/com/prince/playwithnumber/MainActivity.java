package com.prince.playwithnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //data field
    EditText userET;
    Button guessBtn;

    int randomNumberApp,userNumberInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //will hide the title
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        // hide the title bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        userET = findViewById(R.id.numberET);
        guessBtn = findViewById(R.id.guessBtn);

        //number generate
        Random randomNumber = new Random();
        randomNumberApp = randomNumber.nextInt(10) + 1;


        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userNumberInString = userET.getText().toString().trim();
                userNumberInt = Integer.parseInt(userNumberInString);

                if (randomNumberApp<userNumberInt){
                    Toast.makeText(MainActivity.this, "Sorry! Enter a lower number.",Toast.LENGTH_SHORT).show();
                    userET.setText("");
                }
                else if (randomNumberApp>userNumberInt){
                    Toast.makeText(MainActivity.this, "Sorry! Enter a higher number.",Toast.LENGTH_SHORT).show();
                    userET.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Congrats! You entered correct number.", Toast.LENGTH_SHORT).show();
                    userET.setText("");

                    //restart
                    Random randomNumber = new Random();
                    randomNumberApp = randomNumber.nextInt(10) + 1;
                }
            }
        });

    }
}
