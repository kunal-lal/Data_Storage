package com.example.kunal.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedActivity extends AppCompatActivity {

    EditText name,rollno;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        name=(EditText)findViewById(R.id.name);
        rollno=(EditText)findViewById(R.id.roll_no);
        text=(TextView)findViewById(R.id.Text);
        text.setVisibility(View.INVISIBLE);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("roll_no",rollno.getText().toString());
        editor.apply();
        Toast.makeText(this,"Information Saved",Toast.LENGTH_SHORT).show();
        name.setText("");
        rollno.setText("");
    }

    public void display(View view){
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name= sharedPreferences.getString("name","");
        String rollno= sharedPreferences.getString("roll_no","");
        text.setText(name+" "+rollno);
        text.setVisibility(View.VISIBLE);

    }

}
