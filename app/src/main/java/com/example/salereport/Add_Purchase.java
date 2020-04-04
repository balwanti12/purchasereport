package com.example.salereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Purchase extends AppCompatActivity {

    EditText name;
    EditText total;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
       name= findViewById(R.id.editText6);
       total=findViewById(R.id.editText7);
       save=findViewById(R.id.button2);

       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"saved successfully",Toast.LENGTH_SHORT).show();
           }
       });
    }
}
