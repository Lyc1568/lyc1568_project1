package com.example.student.coords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        String Words = new String("Here I am");

        try {
            String fname = "input1";
            File filename = new File(getApplicationContext().getFilesDir(),fname);
            /*FileOutputStream fout = openFileOutput(filename.toString(), 1);
            OutputStreamWriter osw = new OutputStreamWriter(fout);
// записываем строку в файл
            osw.write(Words);
            osw.flush();
            osw.close();*/
            FileWriter f = new FileWriter(filename, true);
            StringWriter fout = new StringWriter();
            fout.write(Words);
            f.write(fout.toString());
            fout.close();
            f.close();

        } catch (Exception e) {
            //вывод сообщения об ошибке
            TextView Error=(TextView) findViewById(R.id.textView);
            Error.setText("we are in the shit11111");
        }

// записываем строку в файл


        try{

            String fname = "input1";
            File filename = new File(getApplicationContext().getFilesDir(),fname);
            int c=0, num=0;
            float X, Y;
            double [][] coords = new double[1000][3];
            FileReader g = new FileReader(filename);
            BufferedReader br = new BufferedReader(g);
            String s="";
            s=br.readLine();
            for(String si:s.split(" ")){
                if(c==0){
                    X= Float.parseFloat(si);
                }
                else if(c==1){
                    Y= Float.parseFloat(si);
                }
                else{
                    coords[c-2][num]=Float.parseFloat(si);
                    num++;
                    if(num==3){num=0;}
                }
                c++;
            }

            TextView Result=(TextView) findViewById(R.id.textView);
            Result.setText("Everuthing alright");

        } catch (Exception e) {
            //вывод сообщения об ошибке
            TextView Error=(TextView) findViewById(R.id.textView);
            Error.setText("we are in the shit22222");
        }


    }
}


