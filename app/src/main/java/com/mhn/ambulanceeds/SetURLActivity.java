package com.mhn.ambulanceeds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SetURLActivity extends AppCompatActivity {

    EditText edtURL;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_url);
        edtURL = (EditText) findViewById(R.id.edtURL);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        edtURL.setText(pref.getString("URLAddress",null));
    }

    public void fnSetURL(View view)
    {

        SharedPreferences.Editor editor = pref.edit();

        editor.putString("URLAddress", edtURL.getText().toString()); // Storing string
        editor.commit();

        Toast.makeText(this,"URL Saved!", Toast.LENGTH_LONG).show();

        finish();
    }
}
