package com.example.office;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    private Button login,register;
    private EditText username,password;
    private String strusername,strpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login=(Button)findViewById(R.id.bt_login);
        register=(Button)findViewById(R.id.bt_register);
        username=(EditText)findViewById(R.id.edit_username);
        password=(EditText)findViewById(R.id.edit_password);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                strusername=username.getText().toString().trim();
                strpassword=password.getText().toString().trim();

                if (TextUtils.isEmpty(strusername)){
                    username.setError("Username Field cannot be empty");
                }else if(TextUtils.isEmpty(strpassword)){
                    password.setError("Password Field cannot be empty");
                }else {

                    final ProgressDialog dialog=new ProgressDialog(login .this );
                    dialog.setMessage("Authentication in progress. Please wait...");
                    dialog.setCancelable(false);
                    dialog.show();

                    final String url=new url().getUrl()+"login.php";

                    StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            dialog.dismiss();

                            if (response.equals("Successful")){
                                Toast.makeText(login.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                                Toast.makeText(login.this, "Welcome"+" "+username, Toast.LENGTH_SHORT).show();
                                Intent success=new Intent(login.this,Home.class);
                                startActivity(success);
                            }else if (response.equals("Unsuccessful")){
                                Toast.makeText(login.this, "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
                                Toast.makeText(login.this, "Your username"+" "+username+" "+"or Password"+" "+password+" "+"is incorrect", Toast.LENGTH_SHORT).show();
                            }

                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    dialog.dismiss();
                                    Toast.makeText(login.this, error.toString(), Toast.LENGTH_SHORT).show();

                                }
                            }){

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<>();
                            params.put("username",strusername);
                            params.put("password",strpassword);
                            return  params;
                        }
                    };

                    RequestQueue requestQueue= Volley.newRequestQueue(login.this);
                    requestQueue.add(stringRequest);

                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                }


            }


        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(login.this,Register.class);
                startActivity(intent2);

            }
        });




    }}