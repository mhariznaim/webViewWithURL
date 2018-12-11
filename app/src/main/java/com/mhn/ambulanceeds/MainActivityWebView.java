package com.mhn.ambulanceeds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivityWebView extends AppCompatActivity {

    WebView webView;
    String strURL;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view);


        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        strURL = pref.getString("URLAddress", null);
        if(pref.getString("URLAddress", null) != null)
        {
            strURL = pref.getString("URLAddress", null);
        }
        else
        {
            strURL = "http://www.google.com";
        }

        webView = (WebView) findViewById(R.id.webvw1);
        webView.loadUrl(strURL);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();

        if(pref.getString("URLAddress", null) != null)
        {
            strURL = pref.getString("URLAddress", null);
        }
        webView.loadUrl(strURL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.setURL) {
            Intent intentActivity = new Intent(this,SetURLActivity.class);
            startActivity(intentActivity);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
