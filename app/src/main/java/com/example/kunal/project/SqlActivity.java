package com.example.kunal.project;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SqlActivity extends AppCompatActivity {
SqlDatabaseAdapter sqlhelper;
    EditText editname,editmarks,editid,editid2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        sqlhelper=new SqlDatabaseAdapter(this);
        editname=(EditText)findViewById(R.id.editName);
        editmarks=(EditText)findViewById(R.id.editMarks);
        editid=(EditText)findViewById(R.id.editTextid);
        editid2=(EditText)findViewById(R.id.editTextid2);
    }

    public void addStudent(View view){

        String name=editname.getText().toString();
        String marks=editmarks.getText().toString();
        if(name.equals("")|| marks.equals("")){
            Toast.makeText(this,"Data not inserted",Toast.LENGTH_LONG).show();
            return;
        }
        long id=sqlhelper.insertdata(name,marks);

        if(id<0 ){
            Toast.makeText(this,"Data not inserted",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Data inserted",Toast.LENGTH_LONG).show();
        }
        editname.setText("");
        editmarks.setText("");
    }

    public void viewData(View view){
     Cursor res=sqlhelper.getallData();
        if(res.getCount()==0){
            showMessage("Error","No data found");
            return;
        }
        StringBuffer stringBuffer=new StringBuffer();
        while(res.moveToNext()){
            stringBuffer.append("ID: "+res.getString(0)+"\n");
            stringBuffer.append("Name: "+res.getString(1)+"\n");
            stringBuffer.append("Marks: "+res.getString(2)+"\n\n");
        }
        showMessage("Student Marks",stringBuffer.toString());
    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

   public void Update(View view){

       String name=editname.getText().toString();
       String marks=editmarks.getText().toString();
       if(name.equals("")|| marks.equals("")){
           Toast.makeText(this,"Data not updated as text is empty",Toast.LENGTH_SHORT).show();
           editid.setText("");
           return;
       }
       boolean isupdated=sqlhelper.updateData(editid.getText().toString(),editname.getText().toString(),editmarks.getText().toString());
       if(isupdated==true)
       Toast.makeText(this,"Data Updated",Toast.LENGTH_SHORT).show();
   else
       Toast.makeText(this,"Data not updated",Toast.LENGTH_SHORT).show();
    editid.setText("");
   }
   public void Delete(View view){
       boolean isdeleted=sqlhelper.deleteData(editid2.getText().toString());
       if(isdeleted==true)
           Toast.makeText(this,"Data is deleted",Toast.LENGTH_SHORT).show();
       else
           Toast.makeText(this,"Data is not deleted",Toast.LENGTH_SHORT).show();
       editid2.setText("");
   }
}
