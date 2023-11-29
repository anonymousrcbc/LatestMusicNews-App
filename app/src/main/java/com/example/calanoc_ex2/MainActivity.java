package com.example.calanoc_ex2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        TextView appTitle = findViewById(R.id.appTitle);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with FirstFragment
                replaceFragment(new FirstFragment());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with SecondFragment
                replaceFragment(new SecondFragment());
            }
        });

        appTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the application by creating a new Intent
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        // Hide both buttons
        if (button1 != null) {
            button1.setVisibility(View.GONE);
        }
        if (button2 != null) {
            button2.setVisibility(View.GONE);
        }
    }
}
