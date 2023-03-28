package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    TextView attempt;
    Button btn;
    int attempt_counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClickListner();
    }
    public  void buttonClickListner(){
        username=findViewById(R.id.editTextTextPersonName);
        password= findViewById(R.id.editTextTextPersonName2);
        btn=findViewById(R.id.button);
        attempt=findViewById(R.id.textView4);
        attempt.setText(Integer.toString(attempt_counter));

        btn.setOnClickListener(view -> {
            if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
                Toast.makeText(MainActivity.this, "successfully login", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this, secondActivity.class);
                startActivities(new Intent[]{intent});
            }
            else {
                Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                attempt.setText(Integer.toString(attempt_counter));
                attempt_counter--;
                if (attempt_counter==0){
                    btn.setEnabled(false);
                }
            }

        });

    }
}