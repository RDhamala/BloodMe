package com.e.bloodme;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class blood_requester extends AppCompatActivity {
    EditText name, age, blood, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = findViewById(R.id.editText3);
        age = findViewById(R.id.editText5);
        blood = findViewById(R.id.editText6);
        address = findViewById(R.id.editText8);
        setContentView(R.layout.activity_blood_requester);
        Button requestBtn = (Button) findViewById(R.id.button);
        Button cancelBtn = (Button) findViewById(R.id.request);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean end = validateForm();
                if(end == true) {
                Intent startIntent = new Intent(getApplicationContext(), requested.class);
                startActivity(startIntent);
            }}
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent endIntent = new Intent(getApplicationContext(), afterlogin.class);
                startActivity(endIntent);
            }
        });



    }private void toastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean validateForm() {
        boolean valid = true;
        String name1 = name.getText().toString();
        if (TextUtils.isEmpty(name1)) {
            name.setError("Required.");
            valid = false;
        } else {
            name.setError(null);
        }

        String age1 = age.getText().toString();

        if (TextUtils.isEmpty(age1)) {
            age.setError("Required.");
            valid = false;
        } else {
            age.setError(null);
        }

        String blood1 = blood.getText().toString();
        if (TextUtils.isEmpty(name1)) {
            blood.setError("Required.");
            valid = false;
        } else {
            blood.setError(null);
        }
        String[] array = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        for(int i=0; i< array.length; i++) {
            if(!array[i].equalsIgnoreCase(blood1)) {
                blood.setError("Invalid.");
                valid = false;
            }
        }


        String address1 = address.getText().toString();
        if (TextUtils.isEmpty(name1)) {
            address.setError("Required.");
            valid = false;
        } else {
            address.setError(null);
        }
        return valid;
    }
}
