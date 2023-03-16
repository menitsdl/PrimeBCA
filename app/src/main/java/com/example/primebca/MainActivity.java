package com.example.primebca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] lan={"C Programming","C++","Java","Kotlin","Swift"};
    Spinner spinner;
    ArrayAdapter adapter;
    Button button,button2;

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "onCreate method call::", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.buttonNext);
        editText=findViewById(R.id.edtOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("message","Message from First Activity");
                intent.putExtra("nextMessage",editText.getText().toString());
                startActivity(intent);
            }
        });

        //initiate Adapter
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,lan);
        spinner.setAdapter(adapter);
      spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
              Toast.makeText(MainActivity.this,lan[position],Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart method call::", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause method call::", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(this, "onPostResume method call::", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity","On Stop:::");
    }
}