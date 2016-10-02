package com.example.kunal.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {
    EditText writemessage;
    TextView messagetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        writemessage=(EditText)findViewById(R.id.writemessage);
        messagetext=(TextView)findViewById(R.id.fileinternaltext);
        messagetext.setVisibility(View.GONE);
    }

    public void writemessage(View view){

        String message=writemessage.getText().toString();
        String filename="internalfile";
        try {
            FileOutputStream fileOutputStream=openFileOutput(filename,MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
            Toast.makeText(this,"Message Saved Internally ",Toast.LENGTH_LONG).show();
            writemessage.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readmessage(View view){

        try {
            String Message;
            FileInputStream fileInputStream =openFileInput("internalfile");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while((Message=bufferedReader.readLine())!=null){

                stringBuffer.append(Message+"\n");
            }
        messagetext.setText(stringBuffer.toString());
            messagetext.setVisibility(View.VISIBLE);
            Toast.makeText(this,"File will not be retained after deletion and is not accessible to external parties",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
