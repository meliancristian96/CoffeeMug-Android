package com.example.melia.coffeemug;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

public class CoffeeMug extends AppCompatActivity {

    int counter = 0;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_mug);


        t = new Thread() {

            public void run() {

                while (counter<99) {

                    try {

                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                    counter++;
                                    showText(String.valueOf(counter));

                                if (counter % 5 == 0 && counter % 3 == 0) {
                                    showText(("CoffeeMug"));

                                } else if (counter % 3 == 0) {
                                    showText("Coffee");

                                } else if (counter % 5 == 0) {
                                    showText("Mug");
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
    }

    public void showText(String text){

        TextView label = (TextView) findViewById(R.id.value);
        label.setText(""+text);

    }

    public void buttonClick(View view){

        t.start();
    }
}
