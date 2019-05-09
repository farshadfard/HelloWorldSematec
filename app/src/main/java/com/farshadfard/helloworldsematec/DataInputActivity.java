package com.farshadfard.helloworldsematec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataInputActivity extends AppCompatActivity {

    EditText edtFirstName;
    EditText edtLastName;
    EditText edtAge;
    EditText edtEmail;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);

        AssignViews();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = edtFirstName.getText().toString();
                String lastName = edtLastName.getText().toString();
                String age = edtAge.getText().toString();
                String email = edtEmail.getText().toString();

                if (firstName.length() < 3)
                {
                    Toast.makeText(DataInputActivity.this, "نام نمی‌تواند کمتر از ۳ کاراکتر باشد", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (lastName.length() < 3)
                {
                    Toast.makeText(DataInputActivity.this, "نام خانوادگی نمی‌تواند کمتر از ۳ کاراکتر باشد", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent dataApprovalActivity = new Intent(DataInputActivity.this, DataApprovalActivity.class);
                dataApprovalActivity.putExtra("firstName", firstName);
                dataApprovalActivity.putExtra("lastName", lastName);
                dataApprovalActivity.putExtra("age", age);
                dataApprovalActivity.putExtra("email", email);
                startActivityForResult(dataApprovalActivity, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                Toast.makeText(this, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void AssignViews()
    {
        try
        {
            edtFirstName = findViewById(R.id.edtFirstName);
            edtLastName = findViewById(R.id.edtLastName);
            edtAge = findViewById(R.id.edtAge);
            edtEmail = findViewById(R.id.edtEmail);
            btnSave = findViewById(R.id.btnSave);
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
