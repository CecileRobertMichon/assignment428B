package com.example.cecilerobertm.amp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private double lettermail(int length, int width, double weight, boolean standard) {
        if (standard) {
            if (length > 245 || length < 140) {
                // TODO handle out of bounds standard length
            } else if (weight < 3.0 || weight > 50.0) {
                // TODO handle out of bounds standard weight
            } else if (width < 90 || width > 156) {
                // TODO handle out of bounds standard width
            }
        } else {
            if (length > 380) {
                // TODO handle out of bounds non-standard length
            } else if (weight > 500) {
                // TODO handle out of bounds non-standard weight
            } else if (width > 270) {
                // TODO handle out of bounds non-standard width
            }
        }
        return 1;
    }
}
