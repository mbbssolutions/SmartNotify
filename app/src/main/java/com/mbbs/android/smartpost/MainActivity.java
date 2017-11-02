package com.mbbs.android.smartpost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignUp(View view) {
        //Intent i =new Intent(MainActivity.this, com.mbbs.android.smartpost.SignupActivity.class);
        //startActivity(i);
    }

    public void Signin(View view) {
        Intent i1 =new Intent();
        startActivity(i1);
    }
}
