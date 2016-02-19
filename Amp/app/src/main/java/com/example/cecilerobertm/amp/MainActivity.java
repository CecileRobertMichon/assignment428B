package com.example.cecilerobertm.amp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cecilerobertm.amp.model.NonStandardEnvelope;
import com.example.cecilerobertm.amp.model.StandardLettermail;

public class MainActivity extends AppCompatActivity {

    boolean nonstandard = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch s = (Switch) findViewById(R.id.switch_standard);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    nonstandard = true;

                } else {
                    nonstandard = false;
                }
            }
        };

        if (s != null) {
            s.setOnCheckedChangeListener(listener);
        }
    }

    public void buttonClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.calculate_button:
                EditText length_input = (EditText) findViewById(R.id.length);
                EditText width_input = (EditText) findViewById(R.id.width);
                EditText weight_input = (EditText) findViewById(R.id.weight);
                try {
                    int length = Integer.valueOf(length_input.getText().toString());
                    int width = Integer.valueOf(width_input.getText().toString());
                    double weight = Integer.valueOf(weight_input.getText().toString());
                    TextView r = (TextView) findViewById(R.id.result_text);
                    if (!nonstandard) {
                        try {
                            StandardLettermail es = new StandardLettermail(length, width, weight);
                            r.setText("$" + es.getCost());
                        } catch (IllegalArgumentException e) {
                            Toast.makeText(this, "Invalid Dimensions", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        try {
                            NonStandardEnvelope ens = new NonStandardEnvelope(length, width, weight);
                            r.setText("$" + ens.getCost());
                        } catch (IllegalArgumentException e) {
                            Toast.makeText(this, "Invalid Dimensions", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Invalid Dimensions", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
