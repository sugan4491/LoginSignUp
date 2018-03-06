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

public class SignupActivity extends AppCompatActivity {
    private Button submit;
    private EditText username;
    private EditText password;
    private EditText phone;
    private EditText email;
    private EditText repassword;

    private RequestQueue RequestQueue;
    private StringRequest StringRequest;

    private String url = "http://yuvagen.com/android_map/register.php";

    private String androidid="androidid";
    private String fcmid="fcmid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        submit = (Button) findViewById(R.id.button6);


        username = (EditText) findViewById(R.id.editText7);
        password = (EditText) findViewById(R.id.editText8);
        phone = (EditText) findViewById(R.id.editText6);
        email = (EditText) findViewById(R.id.editText10);
        repassword = (EditText) findViewById(R.id.editText9);

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String str = username.getText().toString();
                String str2 = password.getText().toString();
                String str3 = phone.getText().toString();
                String str4 = email.getText().toString();
                String str5 = repassword.getText().toString();


                if (str.isEmpty()) {
                    username.setError("Name field cannot be empty");
                } else if (str2.isEmpty()) {
                    password.setError("Password field cannot be left empty");

                } else if (str3.isEmpty()) {
                    phone.setError("Phone number is not entered");

                } else if (str4.isEmpty()) {
                    email.setError("Email id is not entered");
                } else if (!str5.equals(str2)) {
                    repassword.setError("Password Mismatch");
                } else {
                    apicall(username.getText().toString(), email.getText().toString(), password.getText().toString(), androidid, fcmid);

                }
            }


        });


    }

    private void apicall(final String name, final String email, final String password, final String androidid, final String fcmid) {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Loading...", "Please wait...", false, false);
        //RequestQueue initialized
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        progressDialog.show();


        //String Request initialized
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://yuvagen.com/android_map/register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Showing toast message of the response
                        Log.e("responce", "--" + s);
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("responce", "--" + volleyError.getMessage());
                        Toast.makeText(SignupActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);

                params.put("androidid", androidid);
                params.put("fcmid", fcmid);


                //returning parameters
                return params;
            }
        };


//Adding request to the queue
        requestQueue.add(stringRequest);
        requestQueue.start();


    }
}
