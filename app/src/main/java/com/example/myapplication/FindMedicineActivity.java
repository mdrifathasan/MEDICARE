package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindMedicineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_medicine);
        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindMedicineActivity.this, HomeActivity.class));
            }
        });

        CardView familyphysician = findViewById(R.id.cardFDTablet);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent it  = new Intent(FindMedicineActivity.this,MedicineDetailsActivity.class);
                it.putExtra("title","Tablet / Capsules");
                startActivity(it);
            }
        });
        CardView dietcian = findViewById(R.id.cardFDSyrup);
        dietcian .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent it = new Intent(FindMedicineActivity.this,MedicineDetailsActivity.class);
                it.putExtra("title", " Syrup Item");
                startActivity(it);

            }
        });
        CardView dentist = findViewById(R.id.cardFDInjection);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindMedicineActivity.this,MedicineDetailsActivity.class);
                it.putExtra("title", "Injection");
                startActivity(it);
            }
        });


    }
}