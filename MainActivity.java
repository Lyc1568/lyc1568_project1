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
                String Words = new String("1.4 6.98 8.5693 9.0 5.3");

                try {
                        String fname = "input1";
                        File filename = new File(getApplicationContext().getFilesDir(),fname);
                        FileWriter f = new FileWriter(filename, false);
                        StringWriter fout = new StringWriter();
                        fout.write(Words);
                        f.write(fout.toString());
                        fout.close();
                        f.close();
                }
                catch (Exception e) {
                            TextView Error=(TextView) findViewById(R.id.textView);
                            Error.setText("we are in the shit11111");
                }


                try{
                        String fname = "input1", s="";
                        int c=0, num=0;
                        File filename = new File(getApplicationContext().getFilesDir(),fname);
                        float [][] ResCoords = new float[1000][3];
                        FileReader g = new FileReader(filename);
                        BufferedReader br = new BufferedReader(g);
                        s=br.readLine();
                        for(String si:s.split(" ")){
                            ResCoords[c][num]=Float.parseFloat(si);
                            num++;
                            if(num==3){num=0;c++;}

                        }
                        TextView Result1=(TextView) findViewById(R.id.textView);
                        Result1.setText(s.toString());
                }
                catch (Exception e) {
                                TextView Error=(TextView) findViewById(R.id.textView);
                        Error.setText("we are in the shit22222");
                }

            }
 }