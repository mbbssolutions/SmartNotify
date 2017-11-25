package com.mbbs.android.smartpost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    Button back,submit;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView,Mobile,Fname,Lname,CnfrmPassword;

    private AwesomeValidation awesomeValidation;

    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.signup);
        back = (Button) findViewById(R.id.back);
        submit =(Button)findViewById(R.id.signup_form);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        mEmailView =(AutoCompleteTextView)findViewById(R.id.emailid);
        mPasswordView =(EditText)findViewById(R.id.pswrd);
        CnfrmPassword =(EditText)findViewById(R.id.cpwd);
        Mobile =(EditText)findViewById(R.id.num);
        Fname =(EditText)findViewById(R.id.fname);
        Lname =(EditText)findViewById(R.id.lname);


        awesomeValidation.addValidation(this, R.id.emailid, Patterns.EMAIL_ADDRESS,R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.num, "^((\\+){0,1}91(\\s){0,1}(\\-){0,1}(\\s){0,1}){0,1}98(\\s){0,1}(\\-){0,1}(\\s){0,1}[1-9]{1}[0-9]{7}$", R.string.mobileerror);
        awesomeValidation.addValidation(this,R.id.fname,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.lname,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.pswrd,"^([a-zA-Z0-9@*#]{8,15})$",R.string.passerror);

        String pass = mPasswordView.getText().toString();
        String cpass = CnfrmPassword.getText().toString();
        boolean Correct= cpass.equals(pass);
        awesomeValidation.addValidation(this,R.id.cpwd, String.valueOf(Correct),R.string.cpasserror);


        submit.setOnClickListener(this);
    }
    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

            //process the data further
        }
    }

    @Override
    public void onClick(View view) {
           if(view == submit){
            submitForm();
        }

    }
}
