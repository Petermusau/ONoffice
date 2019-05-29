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

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText txtusername, txtemail, txtphone_number,  txtpassword, txtconfirm_password;
    String   username, email, phone_number, location, password, c_password;
    private Button onreg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtusername = (EditText) findViewById(R.id.edt_name);
        txtemail = (EditText) findViewById(R.id.edt_email);
        txtphone_number = (EditText) findViewById(R.id.register_phone_number);
        txtpassword = (EditText) findViewById(R.id.edt_pass);
        txtconfirm_password = (EditText) findViewById(R.id.edt_c_pass);
        onreg = (Button) findViewById(R.id.done);

        onreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = txtusername.getText().toString().trim();
                email = txtemail.getText().toString().trim();
                phone_number = txtphone_number.getText().toString().trim();
                password = txtpassword.getText().toString().trim();
                c_password = txtconfirm_password.getText().toString().trim();

                if (password.equals(c_password)) {
                    if (TextUtils.isEmpty(username)) {
                        txtusername.setError("Username Field cannot be empty");
                    } else if (TextUtils.isEmpty(email)) {
                        txtemail.setError("Email Field cannot be empty");
                    } else if (TextUtils.isEmpty(phone_number)) {
                        txtphone_number.setError("Phone Number Field cannot be empty");
                    } else if (TextUtils.isEmpty(password)) {
                        txtpassword.setError("Password Field cannot be empty");
                    }
                    else if (TextUtils.isEmpty(c_password)) {
                        txtconfirm_password.setError("Confirm Password Field cannot be empty");
                    }
                    else {

                        final ProgressDialog dialog = new ProgressDialog(Register.this);
                        dialog.setMessage("Registration in progress. Please wait...");
                        dialog.setCancelable(false);
                        dialog.show();


                        final String url=new url().getUrl()+"register.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        dialog.dismiss();

                                        if (response.equals("Successful")){
                                            Toast.makeText(Register.this, "Registered", Toast.LENGTH_SHORT).show();
                                            Intent intent=new Intent(Register.this,login.class);
                                            startActivity(intent);
                                        }else if (response.equals("Unsuccessful")){
                                            Toast.makeText(Register.this, "Not registered", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        dialog.dismiss();
                                        Toast.makeText(Register.this, error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<>();
                                params.put("username", username);
                                params.put("email", email);
                                params.put("phone_number", phone_number);
                                params.put("password", password);
                                return params;
                            }

                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
                        requestQueue.add(stringRequest);

                        //Adjusting timeout time
                        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,
                                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    }}}


        });
    }

}