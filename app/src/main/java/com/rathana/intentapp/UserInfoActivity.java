package com.rathana.intentapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.rathana.intentapp.model.User;

import org.w3c.dom.Text;

public class UserInfoActivity extends AppCompatActivity {

    TextView tvUserName;
    TextView tvPassword;
    Button btnEdit;

    static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        tvPassword=findViewById(R.id.tvPassword);
        tvUserName=findViewById(R.id.tvUserName);
        btnEdit=findViewById(R.id.btnEdit);


        //get data from intent
        Intent intent= getIntent();
        if(intent!=null){
            //String name=intent.getStringExtra("username");
            //String password=intent.getStringExtra("password");

            //get object from intent
            User user=intent.getParcelableExtra("user");

            //set data to view
//           tvUserName.setText("User Name : "+name);
//           tvPassword.setText("Password : "+password);
            tvUserName.setText("User Name : "+user.getName());
            tvPassword.setText("Password : "+user.getPassword());
        }


        //set Event to btn Edit
        btnEdit.setOnClickListener(v->{
            Intent i=new Intent(this,EditUserActivity.class);
            startActivityForResult(i,REQUEST_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE==requestCode && resultCode==RESULT_OK){
            User user= data.getParcelableExtra("user");
            tvUserName.setText("User Name : "+user.getName());
            tvPassword.setText("Password : "+user.getPassword());
        }
    }


}
