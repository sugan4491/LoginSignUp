package extopoint.suganya.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    private EditText txt1;
    private EditText txt2;
    private EditText txt3;
    private EditText txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        txt1=(EditText)findViewById(R.id.editText);
        txt2=(EditText)findViewById(R.id.editText2);
        txt3=(EditText)findViewById(R.id.editText3);
        txt4=(EditText)findViewById(R.id.editText4);


        btn1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view){
            Intent i=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
            Toast.makeText(MainActivity.this,"Redirecting to Login Page..!!",Toast.LENGTH_SHORT).show();

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
