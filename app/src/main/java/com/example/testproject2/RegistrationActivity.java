package com.example.testproject2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.ApiUtils;
import com.example.model.Auth;
import com.example.model.ResObj;
import com.example.model.UserModel;
import com.example.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    EditText fname;
    EditText mname;
    EditText lname;
    EditText mobile;
    EditText bdate;
    EditText email;
    EditText pwd;
    EditText conformPwd;
    Button btnSignUp;
    UserService userService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        userService = ApiUtils.getUserService();

        TextView login = (TextView)findViewById(R.id.lnkLogin);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });






        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = (EditText) findViewById(R.id.fname);
                mname = (EditText) findViewById(R.id.txtPwd);
                lname = (EditText) findViewById(R.id.lname);
                mobile = (EditText) findViewById(R.id.mobile);
                bdate = (EditText) findViewById(R.id.bdate);
                email = (EditText) findViewById(R.id.email);
                pwd = (EditText) findViewById(R.id.pwd);
                conformPwd = (EditText) findViewById(R.id.confirmPwd);

                String firstName = fname.getText().toString();
                String password = pwd.getText().toString();
                String conformPssword = conformPwd.getText().toString();
                String birthdate = bdate.getText().toString();
                //validate form
                validateSignUpForm(firstName,password,conformPssword);


                UserModel userModel = new UserModel();
                userModel.setFirstName(firstName);
                userModel.setPassword(password);
                userModel.setBdate(birthdate);
                createUser(userModel);

            }
        });


}

    private boolean validateSignUpForm(String firstName,String password,String confirmPssword){
        if(firstName == null || firstName.trim().length() == 0){
            fname.setError("First Name is required");
            return false;
        }
        if(password == null || password.trim().length() == 0){
            pwd.setError("Password is required");
            return false;
        }
        if(confirmPssword == null || confirmPssword.trim().length() == 0){
            conformPwd.setError("ConfirmPwd is required");
            return false;
        }

        if(!password.equals(confirmPssword)){
            Toast toast=   Toast.makeText(RegistrationActivity.this ,"Password did not match!",Toast.LENGTH_LONG);
            View view =toast.getView();
            view.setBackgroundColor(Color.RED);
            toast.show();
            return false;
        }

        return true;
    }

    private void createUser(final UserModel userModel){
        userService = ApiUtils.getUserService();
        Call call = userService.create(userModel);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    UserModel newUserModel = (UserModel)response.body();
                    if(newUserModel.getId() != null){
                        //login start main activity
                        Toast.makeText(RegistrationActivity.this, newUserModel.getId() , Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(RegistrationActivity.this, JobActivity.class);
                        startActivity(intent);

                    }
                } else {
                    Toast toast=   Toast.makeText(RegistrationActivity.this ,"UserId or password wrong please try again!",Toast.LENGTH_LONG);
                    View view =toast.getView();
                    view.setBackgroundColor(Color.RED);
                    toast.show();

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}

