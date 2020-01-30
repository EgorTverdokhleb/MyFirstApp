package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MyMainActivitys";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // changes for dev

        if (savedInstanceState == null) {
            Log.d(TAG, "MainActivity -> onCreate(), savedInstanceState: ");
        } else {
            Log.d(TAG, "MainActivity -> onCreate(), savedInstanceState: " + savedInstanceState.toString());
        }

        final TextView tv = findViewById(R.id.tv_main_message);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "MainActivity -> onCreate() onButtonClick: v: " + v.toString());
                Toast.makeText(getApplication(), getString(R.string.hello_world), Toast.LENGTH_LONG).show();
                startActivity2();
            }
        });

        final Button starActForResButton = findViewById(R.id.btn_start_act_f_res);
        starActForResButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, DataHelper.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DataHelper.REQUEST_CODE) {
            String dataString = "";
            if (data != null) {
                dataString = data.toString();
            }
            Log.d(TAG, "MainActivity -> onActivityResult: " + requestCode
                    + ", resultCode:" + resultCode + ", data:" + dataString);
        }
    }

    private void startActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(DataHelper.KEY_USER_NAME, "Oleg");
        intent.putExtra(DataHelper.KEY_USER_SEC_NAME, " Aleksandrov");
        intent.putExtra(DataHelper.KEY_USER_AGE, 25);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity -> onRestart() ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity -> onStart() ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity -> onResume() ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity -> onPause() ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity -> onStop() ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity -> onDestroy() ");
    }
}
