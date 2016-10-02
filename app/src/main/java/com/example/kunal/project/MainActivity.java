package com.example.kunal.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SQLclick(View view){
        Intent intent=new Intent(this,SqlActivity.class);
        startActivity(intent);
    }
    public void Shared(View view){
        Intent intent=new Intent(this,SharedActivity.class);
        startActivity(intent);
    }
    public void fileinternal(View view){
        Intent intent=new Intent(this,FileActivity.class);
        startActivity(intent);
    }
    public void fileExternal(View view){
        Intent intent=new Intent(this,FileExtActivity.class);
        startActivity(intent);
    }
}
