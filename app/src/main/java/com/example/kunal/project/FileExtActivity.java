package com.example.kunal.project;

import android.content.Context;
import android.os.Environment;
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

public class FileExtActivity extends AppCompatActivity {
EditText extText;
    TextView txtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_ext);
        extText=(EditText)findViewById(R.id.writeextmessage);
        txtText=(TextView)findViewById(R.id.fileexternaltext);
        txtText.setVisibility(View.INVISIBLE);
    }

    public void writeextdeletionmessage(View view){

        File folder=getExternalFilesDir("Project");
        File file=new File(folder,"mydata.txt");

            String message=extText.getText().toString();

            try {
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(message.getBytes());
                fileOutputStream.close();
                extText.setText("");
                Toast.makeText(this,"Message Stored Externally at: "+folder ,Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    public void readextdeletemessage(View view){

        File folder=getExternalFilesDir("Project");
        File file=new File(folder,"mydata.txt");
        String message;

        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();

            while((message=bufferedReader.readLine())!=null){

                stringBuffer.append(message +"\n");

            }
            txtText.setText(stringBuffer.toString());
            txtText.setVisibility(View.VISIBLE);
            Toast.makeText(this,"File is not retained after deletion and is not accessible to external parties",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeextmessage(View view){

        String state;
        state=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){

            File root= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File directory=new File(root.getAbsolutePath()+"/ProjectFile");
            if(!directory.exists()) {
                directory.mkdir();

            }
            File file=new File(directory,"Message.txt");
            String message=extText.getText().toString();

            try {
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(message.getBytes());
                fileOutputStream.close();
                extText.setText("");
                Toast.makeText(this,"Message Saved Externally at: "+directory,Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this,"External Storage not available",Toast.LENGTH_SHORT).show();
        }


    }

    public void readextmessage(View view){

        File root= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File directory=new File(root.getAbsolutePath()+"/ProjectFile");
        File file=new File(directory,"Message.txt");
        String message;

        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();

            while((message=bufferedReader.readLine())!=null){

                stringBuffer.append(message +"\n");

            }
            txtText.setText(stringBuffer.toString());
            txtText.setVisibility(View.VISIBLE);
            Toast.makeText(this,"File retained after deletion and accessible to external parties",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeroot(View view){


        String state;
        state=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){

            File root= Environment.getExternalStorageDirectory();
            File directory=new File(root.getAbsolutePath()+"/RootFile");
            if(!directory.exists()) {
                directory.mkdir();

            }
            File file=new File(directory,"Rootmsg.txt");
            String message=extText.getText().toString();

            try {
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(message.getBytes());
                fileOutputStream.close();
                extText.setText("");
                Toast.makeText(this,"Message Saved Externally at: "+directory,Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this,"External Storage not available",Toast.LENGTH_SHORT).show();
        }

    }
    public void readroot(View view){

        File root= Environment.getExternalStorageDirectory();
        File directory=new File(root.getAbsolutePath()+"/RootFile");
        File file=new File(directory,"Rootmsg.txt");
        String message;

        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();

            while((message=bufferedReader.readLine())!=null){

                stringBuffer.append(message +"\n");

            }
            txtText.setText(stringBuffer.toString());
            txtText.setVisibility(View.VISIBLE);
            Toast.makeText(this,"File retained after deletion and accessible to external parties",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
