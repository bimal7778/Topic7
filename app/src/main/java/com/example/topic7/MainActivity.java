package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
    EditText etword, etmeaning;
    Button btnsave, btnVisit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etword = findViewById(R.id.etWord);
        etmeaning = findViewById(R.id.etMeaning);
        btnsave = findViewById(R.id.btnAddword);
        btnVisit = findViewById(R.id.btnVisit);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(intent);
            }
        });
     }
    private void save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("file.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etword.getText().toString() + "->" + etmeaning.getText().toString());
            Toast.makeText(this, "saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Log.d("Dictionary app", "Error"+e.toString());
            e.printStackTrace();
        }
    }
}
