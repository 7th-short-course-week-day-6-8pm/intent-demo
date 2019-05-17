package com.rathana.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin=findViewById(R.id.btnLogin);
        Button btnImplicit=findViewById(R.id.btnImplicit);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(
                        MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        //create implicit intent
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                //intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

    }
}
