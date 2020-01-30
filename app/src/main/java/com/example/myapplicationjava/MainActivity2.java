package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private final String TAG = "MyMainActivitys";

    private String userName;
    private String secondUserName;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Log.d(TAG, "MainActivity2 -> onCreate(), savedInstanceState: ");
        } else {
            Log.d(TAG, "MainActivity2 -> onCreate(), savedInstanceState: " + savedInstanceState.toString());
        }

        userName = getIntent().getStringExtra(DataHelper.KEY_USER_NAME);
        secondUserName = getIntent().getStringExtra(DataHelper.KEY_USER_SEC_NAME);
        age = getIntent().getIntExtra(DataHelper.KEY_USER_AGE, -1);
        Log.d(TAG, "MainActivity2 -> onCreate(), getIntent: " + userName + ", " +
                secondUserName + ", " + age);

        TextView tvName = findViewById(R.id.tv_user_name);
        TextView tvSecName = findViewById(R.id.tv_second_name);
        TextView tvAge = findViewById(R.id.tv_age);

        try {
            tvName.setText(userName);
            tvSecName.setText(secondUserName);
            tvAge.setText(age);
        } catch (Exception e) {
            Log.e(TAG, "MainActivity2 -> onCreate(), savedInstanceState: " + e.toString());
        }

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = new Intent();
        intent.putExtra("TEMP", "DATA_RETRIEVED");
        setResult(DataHelper.REQUEST_CODE, intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity2 -> onRestart() ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity2 -> onStart() ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity2 -> onResume() ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity2 -> onPause() ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity2 -> onStop() ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity2 -> onDestroy() ");
    }
}
