package bellayang.temple.edu.signupform;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {
    //Global variables fro necessary fields.
    EditText name, email, password, confirmation;
    Button save;
    String str_name, str_email, str_password, str_confirmation;


    //method for creating and displaying user internface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.e_mail);
        password = (EditText) findViewById(R.id.password);
        confirmation = (EditText) findViewById(R.id.confirm);
        save = (Button) findViewById(R.id.save);


        save.setOnClickListener(this);


    }

    //methods that checks if the two entered fileds mathces.
    public boolean password_checker(String p, String c) {
        if (p.equals(c)) {
            return true;
        } else {
            return false;
        }

    }

    //This si an important override message. Please listen to the recording.
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.save) { //if the viewid is equal to the id ofthe button then do all the task in the curly braces.

            //all these outputs string outcomes.
            str_name = name.getText().toString().trim(); //initializing variables
            str_email = email.getText().toString().trim();
            str_password = password.getText().toString().trim();
            str_confirmation = confirmation.getText().toString().trim();

            //Fetching the application contect hadler
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT; //getting the time

            //If any field is empty display a Toast to tell the user they must enter all information //makes sure that every field has data entered. If any field is empty displays a Toast to tell the user they must enter all infomraiton.
            if (str_name.equals("") || str_email.equals("") || str_password.equals("") ||
                    str_confirmation.equals("")) {
                Toast.makeText(FormActivity.this, "One of the fields are empty", duration).show();

                //If password is incorrect then execute the code inside the else if llop.
            } else if (!password_checker(str_password, str_confirmation)) {
                //output.setText("password doesnt match");
                Toast.makeText(FormActivity.this, "Password does not match", duration).show();
                //Succuesslfully signed up
            } else {
                Toast.makeText(FormActivity.this, str_name + ", Successfuly Sgined-Up", duration).show();
            }
        }

    }
}






