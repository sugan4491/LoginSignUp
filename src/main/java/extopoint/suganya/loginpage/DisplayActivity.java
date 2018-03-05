package extopoint.suganya.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DisplayActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name=(EditText)findViewById(R.id.txtname);
        email=(EditText)findViewById(R.id.txtmail);
        password=(EditText)findViewById(R.id.txtpassword);



    }
}
