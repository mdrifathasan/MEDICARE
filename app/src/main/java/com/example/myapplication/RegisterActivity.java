package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRrgUsername);
        edEmail = findViewById(R.id.editTextTextRegEmail);
        edPassword = findViewById(R.id.editTextTextRegPassword);
        edConfirm =  findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        TV = findViewById(R.id.textView6);

        TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = edUsername.getText().toString();
                String Email = edEmail.getText().toString();
                String Password = edPassword.getText().toString();
                String Confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"Healthcare",null,1);
                if(Username.length()==0 || Email.length()==0 || Password.length()==0 || Confirm.length()==0){

                    Toast.makeText(getApplicationContext(), "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(Password.compareTo(Confirm)==0) {
                        if (isvalid(Password)) {
                            db.register(Username,Email,Password);

                            Toast.makeText(getApplicationContext(), "Record Inserted ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters,having Letter,digit and special Symbol ", Toast.LENGTH_SHORT).show();

                        }
                    } else {


                        Toast.makeText(getApplicationContext(), "Password And Confirm Password Don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
    public static boolean isvalid(String Passwordhear){
        int f1=0,f2=0,f3=0;
        if(Passwordhear.length() < 8){
            return false;
        }else {

            for(int p =0; p < Passwordhear.length();p++){
                if(Character.isLetter(Passwordhear.charAt(p))){
                    f1=1;
                }
            }
            for (int r = 0; r < Passwordhear.length();r++){
                if(Character.isDigit(Passwordhear.charAt(r))){
                    f2=1;
                }
            }
            for(int s =0;s<Passwordhear.length(); s++){
                char c = Passwordhear.charAt(s);
                if(c>=33 && c<=46 || c==64) {
                    f3=1;

                }
            }
            if(f1==1 && f2==1 &&f3==1)
                return true;
            return false;
        }
    }
}