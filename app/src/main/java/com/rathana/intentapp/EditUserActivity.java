package com.rathana.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rathana.intentapp.model.User;

public class EditUserActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnSaveChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        username=findViewById(R.id.edUserName);
        password=findViewById(R.id.edpassword);
        btnSaveChange=findViewById(R.id.btnSaveChange);

        btnSaveChange.setOnClickListener(v->{
            User user=new User();
            user.setName(username.getText().toString());
            user.setPassword(password.getText().toString());

            Intent intent=new Intent();
            Bundle b=new Bundle();
            b.putParcelable("user",user);
            intent.putExtras(b);

            setResult(RESULT_OK,intent);

            finish();
        });


    }
}
