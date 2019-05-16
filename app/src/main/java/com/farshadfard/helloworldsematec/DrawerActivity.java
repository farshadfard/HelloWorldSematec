package com.farshadfard.helloworldsematec;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity {

    Button btnInputData;
    Button btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        AssignViews();

        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawerActivity.this, DataInputActivity.class);
                startActivity(intent);
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawerActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AssignViews()
    {
        try
        {
            btnInputData = findViewById(R.id.btnInputData);
            btnShowList = findViewById(R.id.btnShowList);
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
