package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicineDetailsActivity extends AppCompatActivity {


    private String[][] Medicine_details1 =
            {
                    {"Medicine Name : Napa ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Panadol","10"},
                    {"Medicine Name : Napa_Extra ", "Exp : 02/03/2025","Net : 20mg ","brand name:  Motrin","20"},
                    {"Medicine Name : Paracetamol ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Bufferin","40"},
                    {"Medicine Name : Ibuprofen ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Reactine","55"},
                    {"Medicine Name : Aspirin ", "Exp : 02/02/2025","Net : 10mg ","brand name:   Losec","100"},
                    {"Medicine Name : Cetirizine ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Moxatag","105"},
                    {"Medicine Name : Omeprazole ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Benadryl","75"},
                    {"Medicine Name : Diphenhydramine ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Fortamet","65"},
                    {"Medicine Name : Metformin ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Lipex","5"},
                    {"Medicine Name : Simvastatin ", "Exp : 02/02/2025","Net : 10mg ","brand name:  Lipitor","120"}
            };
    private String[][] Medicine_details2 =
            {
                    {"Medicine Name : Benadryl Syrup ", "Exp : 02/02/2025","Net : 100mg ","brand name:  Panadol","100"},
                    {"Medicine Name : Cough syrup ", "Exp : 02/03/2025","Net : 200mg ","brand name:  Motrin","200"},
                    {"Medicine Name : Amoxicillin Syrup ", "Exp : 02/02/2025","Net : 100mg ","brand name:  Bufferin","300"},
                    {"Medicine Name : Ibuprofen Syrup ", "Exp : 02/02/2025","Net : 100mg ","brand name:  Reactine","400"},
                    {"Medicine Name : Paracetamol Syrup ", "Exp : 02/02/2025","Net : 105mg ","brand name:   Losec","500"},
                    {"Medicine Name : Dextromethorphan Syrup ", "Exp : 02/02/2025","Net : 200mg ","brand name:  Moxatag","600"},
                    {"Medicine Name : Diphenhydramine Syrup ", "Exp : 02/02/2025","Net : 50mg ","brand name:  Benadryl","700"},
                    {"Medicine Name : Zinc Syrup ", "Exp : 02/02/2025","Net : 60mg ","brand name:  Fortamet","650"},
                    {"Medicine Name : Multivitamin Syrup ", "Exp : 02/02/2025","Net : 110mg ","brand name:  Lipex","500"},
                    {"Medicine Name : Cetirizine Syrup ", "Exp : 02/02/2025","Net : 80mg ","brand name:  Lipitor","1200"}
            };
    private String[][] Medicine_details3 =
            {
                    {"Medicine Name : Epinephrine ", "Exp : 02/02/2025","Net : 100mg ","brand name:  Panadol","100"},
                    {"Medicine Name : Insulin ", "Exp : 02/03/2025","Net : 200mg ","brand name:  Motrin","200"},
                    {"Medicine Name : Morphine ", "Exp : 02/02/2025","Net : 100mg ","brand name:  Bufferin","300"},
                    {"Medicine Name : Dexamethasone ", "Exp : 02/02/2025","Net : 100mg ","brand name:  Reactine","400"},
                    {"Medicine Name : Ondansetron ", "Exp : 02/02/2025","Net : 105mg ","brand name:   Losec","500"},
                    {"Medicine Name : Ranitidine ", "Exp : 02/02/2025","Net : 200mg ","brand name:  Moxatag","600"},
                    {"Medicine Name : Erythropoietin ", "Exp : 02/02/2025","Net : 50mg ","brand name:  Benadryl","700"},
                    {"Medicine Name : Lidocaine ", "Exp : 02/02/2025","Net : 60mg ","brand name:  Fortamet","650"},
                    {"Medicine Name : Ceftriaxone ", "Exp : 02/02/2025","Net : 110mg ","brand name:  Lipex","500"},
                    {"Medicine Name : Diazepam ", "Exp : 02/02/2025","Net : 80mg ","brand name:  Lipitor","1200"}
            };





    TextView tv;
    Button btn;
    String[][] MedicineDetails = {}; // Rename to camelCase for consistency
    HashMap<String,String> item;
    ArrayList<HashMap<String,String>> list; // Change to ArrayList
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicine_details);
        tv = findViewById(R.id.textViewFMTitle);
        btn = findViewById(R.id.ButtonFMBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Tablet / capsules") == 0)
            MedicineDetails = Medicine_details1;
        else
        if(title.compareTo("Syrup") == 0)
            MedicineDetails = Medicine_details2;
        else
            MedicineDetails = Medicine_details3;






        // Initialize doctor details based on the received title...

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineDetailsActivity.this, FindMedicineActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i = 0; i < MedicineDetails.length; i++) {
            item = new HashMap<>();
            item.put("Line_a", MedicineDetails[i][0]);
            item.put("Line_b", MedicineDetails[i][1]);
            item.put("Line_c", MedicineDetails[i][2]);
            item.put("Line_d", MedicineDetails[i][3]);
            item.put("Line_e", "Prize: " + MedicineDetails[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multiline,
                new String[]{"Line_a", "Line_b", "Line_c", "Line_d", "Line_e"},
                new int[]{R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e});

        ListView listView = findViewById(R.id.listViewFM); // Change variable name to listView
        listView.setAdapter(sa); // Correct variable name
    }
}
