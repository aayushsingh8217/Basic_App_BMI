package com.testpro.my_app_bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView res_txt;
        EditText wti,htft,htinch;
        Button btnclc;
        LinearLayoutCompat llm;

        wti=findViewById(R.id.wt);
        htft=findViewById(R.id.htft);
        htinch=findViewById(R.id.htinch);
        btnclc=findViewById(R.id.btncalc);
        res_txt=findViewById(R.id.TextVid);
        llm=findViewById(R.id.llmain);
        btnclc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt= Integer.parseInt(wti.getText().toString());
                int htf=Integer.parseInt(htft.getText().toString());
                int hti=Integer.parseInt(htinch.getText().toString());

                int totinch=(htf*12)+hti;

                double totalcm=totinch*2.53;

                double totm=totalcm/100;

                double bmi=wt/(totm*totm);

                if(bmi<18.5) {
                    res_txt.setText("Halkapan hai sahab aapko aur khao");
                    llm.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.halkapan));
                }
                else if(bmi>=18.5 && bmi<25) {
                    res_txt.setText("Shabaash sab sahi hai");
                    llm.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.thksab));
                }
                else if(bmi>=25 && bmi<30) {
                    res_txt.setText("Motapa hai aapko");
                    llm.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.bhari));
                }
                else if (bmi>30) {
                    res_txt.setText("take care of your health for god's sake");
                    llm.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.vvoverwt));
                }
            }
        });
    }
}
