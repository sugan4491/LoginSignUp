package extopoint.suganya.loginpage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    private EditText txtemail;
    private EditText txtpassword;

    private String url = "http://yuvagen.com/android_map/login.php";

    private RequestQueue requestQueue;
    private StringRequest stringRequest;


    private String androidid="androidid";
    private String fcmid="fcmid";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.loginbutton);
        btn2=(Button)findViewById(R.id.signupbutton);
        txtemail=(EditText)findViewById(R.id.logemail);
        txtpassword=(EditText)findViewById(R.id.logpassword);


        btn1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view){
            //Intent i=new Intent(MainActivity.this,LoginActivity.class);
            //startActivity(i);
            //Toast.makeText(MainActivity.this,"Redirecting to Login Page..!!",Toast.LENGTH_SHORT).show();

            String strlogemail=txtemail.getText().toString();
            String strlogpassword=txtpassword.getText().toString();

            if (strlogemail.isEmpty()){
                txtemail.setError("This field is mandatory");
                 }
                 else if (strlogpassword.isEmpty()){
                txtpassword.setError("Plz enter your Password");
            }
            else {
                     loginapicall(txtemail.getText().toString(),txtpassword.getText().toString());
            }
        }

            private void loginapicall(final String txtemail, final String txtpassword) {

            final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Login Initiated","Verifying your Credentials",false,false);
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                progressDialog.show();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, "http://yuvagen.com/android_map/login.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.e("response", "------" + response);
                                progressDialog.dismiss();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("response","------" +error.getMessage());
                                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                })
                {

                    protected Map<String, String> getParams() throws AuthFailureError {
                        //Converting Bitmap to String
                        HashMap<String, String> params = new HashMap<String, String>();
                        params.put("email",txtemail);
                        params.put("password", txtpassword);

                        params.put("androidid", androidid);
                        params.put("fcmid", fcmid);


                        //returning parameters
                        return params;
                    }
                };

                requestQueue.add(stringRequest);
                requestQueue.start();

            }


        });




        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Registration..!!",Toast.LENGTH_SHORT).show();

            }

        });




    }

}
