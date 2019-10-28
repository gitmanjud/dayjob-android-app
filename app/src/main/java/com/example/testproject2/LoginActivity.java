package com.example.testproject2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.ApiUtils;
import com.example.model.Auth;
import com.example.model.ResObj;
import com.example.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity  extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    private Toolbar bar;

    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bar= findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        userService = ApiUtils.getUserService();


/*
        TextView register = (TextView)findViewById(R.id.lnkRegister);
        if(register.getText().toString().equalsIgnoreCase("New to Day Job? Register here")){
            register.setMovementMethod(LinkMovementMethod.getInstance());
            Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        }
*/


    //register page
        TextView register = (TextView)findViewById(R.id.lnkRegister);
            register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });


        //forgot password need to do
        TextView forgotPwd = (TextView)findViewById(R.id.forgotpwd);
        forgotPwd.setMovementMethod(LinkMovementMethod.getInstance());
        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUsername = (EditText) findViewById(R.id.txtEmail);
                edtPassword = (EditText) findViewById(R.id.txtPwd);

                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //validate form
                if(validateLogin(username, password)){
                    //do login
                    doLogin(username, password);
                }
            }
        });
    }

    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            edtUsername.setError("UserId is required");
            return false;
        }
        if(password == null || password.trim().length() == 0){
            edtPassword.setError("Password is required");
            return false;
        }
        return true;
    }

    private void doLogin(final String username,final String password){
        userService = ApiUtils.getUserService();
        Auth auth = new Auth();
        auth.setUserId(username);
        auth.setPassword(password);
        Call call = userService.login(auth);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    ResObj resObj = (ResObj)response.body();
                    if(resObj.isSuccess()){
                        //login start main activity
                        Toast.makeText(LoginActivity.this, "login successfull", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, JobActivity.class);
                        startActivity(intent);

                    }
                } else {
                    Toast toast=   Toast.makeText(LoginActivity.this ,"UserId or password wrong please try again!",Toast.LENGTH_LONG);
                    View view =toast.getView();
                    view.setBackgroundColor(Color.RED);
                    toast.show();

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(LoginActivity.this, "something wrong please try again", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mn =getMenuInflater();
        mn.inflate(R.menu.appmenu,menu);



        MenuItem.OnActionExpandListener ml = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                Toast.makeText(LoginActivity.this,"searchdajads",Toast.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(LoginActivity.this,"searchdajads",Toast.LENGTH_LONG).show();
                return true;
            }
        };



        MenuItem it = menu.findItem(R.id.phid);

        it.setOnActionExpandListener(ml);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.phid:
                Intent intent = new Intent(LoginActivity.this, TestActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}


