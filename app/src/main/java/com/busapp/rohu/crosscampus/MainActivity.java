package com.busapp.rohu.crosscampus;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.Object;
import java.util.Date;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.net.HttpURLConnection;
import java.net.URL;

public class gatheringScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        Intent intent = getIntent();
        String buildingID = intent.getExtras().getString("buildingID");



//        long unixTime = System.currentTimeMillis() / 1000L;



        GPSTracker gps = new GPSTracker(this);
        if(gps.canGetLocation())
        {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            String strLat = "" + latitude;
            String strLong = "" + longitude;
            Toast.makeText(getApplicationContext(), strLat + " " + strLong, Toast.LENGTH_LONG).show();
        }

        String bestMethod = " bus";
        String busTime = 19 + " min";
        String walkTime = 19 + " min";

        Intent passGathering = new Intent(this, decisionScreen.class);
        System.out.println("closing the rotating icon");
        Bundle extras = new Bundle();
        extras.putString("bestMethod", bestMethod);
        extras.putString("busTime", busTime);
        extras.putString("walkTime", walkTime);
        passGathering.putExtras(extras);
        startActivity(passGathering);

//        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
