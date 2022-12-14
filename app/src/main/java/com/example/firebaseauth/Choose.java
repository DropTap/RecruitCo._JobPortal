package com.example.firebaseauth;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Choose extends Activity {

    Button button7;
    Button button8;
    Button profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button employee = findViewById(R.id.button8);
        Button employer = findViewById(R.id.button7);
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Choose.this,Employee.class));
                finish();
                Toast.makeText(Choose.this, "Successful!!", Toast.LENGTH_SHORT).show();
            }
        });
        employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Choose.this,EmployerActivity.class));
                finish();
                Toast.makeText(Choose.this, "Successful!!", Toast.LENGTH_SHORT).show();
            }
        });

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose.this, EmployerActivity.class);
                startActivity(intent);

            }
        });

        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose.this, Employee.class);
                startActivity(intent);

            }
        });

        profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose.this, UpdateProfile.class);
                startActivity(intent);

            }
        });
    }
}
