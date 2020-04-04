package com.example.salereport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button addsale;
    TextView from;
    TextView to;
    Spinner spin1;
    Spinner spin2;
    EditText fromdate;
    EditText todate;
    DatePickerDialog datePickerDialog;
    DatePickerDialog datePickerDialog1;
    ArrayAdapter arrayAdapter1;
    ArrayAdapter arrayAdapter2;
        String[] s1={"Today","This week","This month","This quarter","This financial year","custom" };
        String[] s2={"Purchase & Dr.Note","Purchase","Debit Note"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addsale=findViewById(R.id.button);
        addsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Add_Purchase.class);
                startActivity(i);
            }
        });
        from=findViewById(R.id.textView3);
        to=findViewById(R.id.textView4);
        todate=findViewById(R.id.editText4);
         fromdate=findViewById(R.id.editText3);
         fromdate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                final int year1=calendar.get(Calendar.YEAR);
                 final int month1=calendar.get(Calendar.MONTH);
                 final int day1=calendar.get(Calendar.DAY_OF_MONTH);

               datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                     fromdate.setText(day1+"-"+month1+"-"+year1);
                   }
               },year1,month1,day1);
               datePickerDialog.show();
             }
         });
        fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                final int year1=calendar.get(Calendar.YEAR);
                final int month1=calendar.get(Calendar.MONTH);
                final int day1=calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fromdate.setText(day1+"-"+month1+"-"+year1);
                    }
                },year1,month1,day1);
                datePickerDialog.show();
            }
        });
        todate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar1=Calendar.getInstance();
                final int year2=calendar1.get(Calendar.YEAR);
                final int month2=calendar1.get(Calendar.MONTH);
                final int day2=calendar1.get(Calendar.DAY_OF_MONTH);

                datePickerDialog1=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        todate.setText(day2+"-"+month2+"-"+year2);
                    }
                },year2,month2,day2);
                datePickerDialog1.show();
            }
        });


        spin1=findViewById(R.id.spinner);
        arrayAdapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(arrayAdapter1);

        spin2=findViewById(R.id.spinner2);
        arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(arrayAdapter2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         int id=item.getItemId();
         if(id == R.id.first) {
             Toast.makeText(getApplicationContext(), "access to pdf", Toast.LENGTH_SHORT).show();
         }
         if(id==R.id.second )
         {
             Toast.makeText(getApplicationContext(), "access to excel", Toast.LENGTH_SHORT).show();
         }
        return super.onOptionsItemSelected(item);
    }

}
