package com.farshadfard.helloworldsematec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DataApprovalActivity extends AppCompatActivity {

    TextView txtFirstName;
    TextView txtLastName;
    TextView txtAge;
    TextView txtEmail;
    Button btnYes;
    Button btnNo;

    String firstName;
    String lastName;
    String age;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_approval);

        AssignViews();

        Intent intent = getIntent();
        firstName = intent.getStringExtra("firstName");
        lastName = intent.getStringExtra("lastName");
        age = intent.getStringExtra("age");
        email = intent.getStringExtra("email");

        txtFirstName.setText(firstName);
        txtLastName.setText(lastName);
        txtAge.setText(age);
        txtEmail.setText(email);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(DataApprovalActivity.this).edit().putString("firstName", firstName).apply();
                PreferenceManager.getDefaultSharedPreferences(DataApprovalActivity.this).edit().putString("lastName", lastName).apply();
                PreferenceManager.getDefaultSharedPreferences(DataApprovalActivity.this).edit().putString("age", age).apply();
                PreferenceManager.getDefaultSharedPreferences(DataApprovalActivity.this).edit().putString("email", email).apply();

                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    private void AssignViews()
    {
        try
        {
            txtFirstName = findViewById(R.id.txtFirstName);
            txtLastName = findViewById(R.id.txtLastName);
            txtAge = findViewById(R.id.txtAge);
            txtEmail = findViewById(R.id.txtEmail);
            btnYes = findViewById(R.id.btnYes);
            btnNo = findViewById(R.id.btnNo);
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
