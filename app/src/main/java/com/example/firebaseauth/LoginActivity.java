package com.example.firebaseauth;

import androidx.annotation.NonNull;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText3);
        Button login = findViewById(R.id.sbutton);
        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();

                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(LoginActivity.this,"Complete the credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt_password.length() < 6) {
                        Toast.makeText(LoginActivity.this, "Password is Short!", Toast.LENGTH_SHORT).show();
                    } else
                        loginUser(txt_email, txt_password);
                }
            }
        });
    }
    private void loginUser(String email, String password) {
        Log.i("Executor", "popop");

        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(LoginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Logged in Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,Choose.class));
                finish();
            }
        }).addOnFailureListener(LoginActivity.this, new OnFailureListener()  {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "may problema", Toast.LENGTH_LONG).show();
            }
        });

    }
}
