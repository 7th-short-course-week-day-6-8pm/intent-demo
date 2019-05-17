package com.rathana.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rathana.intentapp.model.User;

public class LoginActivity extends AppCompatActivity {


    EditText username,password;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.edUserName);
        password=findViewById(R.id.edpassword);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v->{
                Intent intent=new Intent(this,UserInfoActivity.class);

                //get values from editText object
                String name=username.getText().toString();
                String pass=password.getText().toString();


                User user =new User();
                user.setName(name);
                user.setPassword(pass);

                //send name and pass to screen user info
                //intent.putExtra("username",name);
                //intent.putExtra("password",pass);

                // SEND OBJECT VIA INTENT
                Bundle b=new Bundle();
                b.putParcelable("user",user);
                intent.putExtras(b);

                startActivity(intent);
        });

    }
}




