package com.example.firebaseauth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class EmployerActivity extends AppCompatActivity {

    public EditText editname;
    public EditText editcname;
    public EditText editphone;
    public EditText editcity;
    public EditText editcountry;
    public EditText editvac;
    public Button enter;
   private FirebaseFirestore db;

    public EmployerActivity() {

    }


    private EditText mName, mCompany, mPhoneNumber, mCity, mCountry, mVacantPosition;
    private Button mbutton4;

    private FirebaseDatabase bd = FirebaseDatabase.getInstance();
    private DatabaseReference root = bd.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        mName = findViewById(R.id.editText2);
        mCompany= findViewById(R.id.editText4);
        mPhoneNumber = findViewById(R.id.editText7);
        mCity = findViewById(R.id.editText8);
        mCountry = findViewById(R.id.editText9);
        mVacantPosition = findViewById(R.id.editText10);
        mbutton4 = findViewById(R.id.button4);

        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                String company = mCompany.getText().toString();
                String phonenumber = mPhoneNumber.getText().toString();
                String city = mCity.getText().toString();
                String country = mCountry.getText().toString();
                String vacantposition = mVacantPosition.getText().toString();

                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("name" , name);
                userMap.put("company" , company);
                userMap.put("phonenumber" , phonenumber);
                userMap.put("city" , city);
                userMap.put("country" , country);
                userMap.put("vacantposition" , vacantposition);

                root.setValue(userMap);

            }
        });

        editname = findViewById(R.id.editText2);
        editcname = findViewById(R.id.editText4);
        editphone = findViewById(R.id.editText7);
        editcity = findViewById(R.id.editText8);
        editcountry = findViewById(R.id.editText9);
        editvac=findViewById(R.id.editText10);
    enter =findViewById(R.id.button4);
        db = FirebaseFirestore.getInstance();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name=editname.getText().toString();
                String cname=editcname.getText().toString();
                String phone=editphone.getText().toString();
                String city=editcity.getText().toString();
                String country=editcountry.getText().toString();
                String vac=editvac.getText().toString();
                Map<String, Object> user=new HashMap<>();
                user.put("name",name);
                user.put("company name",cname);
                user.put("phone",phone);
                user.put("city",city);
                user.put("country",country);
                user.put("vacancy",vac);


                db.collection("employers").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(EmployerActivity.this, "Details added successfully!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EmployerActivity.this, "Error "+e, Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(EmployerActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    public void enter(View view) {
    }
}