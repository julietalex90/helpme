package com.example.julie.rescueemergency;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);
        Button bt1=(Button)findViewById(R.id.btnhospital);
        Button bt2=(Button)findViewById(R.id.btnworkshop);
        Button bt3=(Button)findViewById(R.id.btnpolice);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1=new Intent(userHomepage.this,HospitalHomepage.class);
                startActivity(int1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(userHomepage.this,workshopHomepage.class);
                startActivity(int2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3=new Intent(userHomepage.this,policestationHomepage.class);
                startActivity(int3);
            }
        });


    }




    }





