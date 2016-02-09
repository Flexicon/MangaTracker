package com.flexicondev.mangatracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        new GetMangaSiteTask().execute();
    }

    private class GetMangaSiteTask extends AsyncTask<Void, Void, MangaSite[]> {
        @Override
        protected MangaSite[] doInBackground(Void... params) {
            try {
                HttpResponse<String> response = Unirest.get("https://doodle-manga-scraper.p.mashape.com/")
                        .header("X-Mashape-Key", "nqtUYTVuRImshL0Fl8E1RWnORoSFp1B5Vi7jsnA8CPHWYfPXtl")
                        .header("Accept", "text/plain")
                        .asString();
                String res = response.getBody();

                Gson gson = new Gson();
                MangaSite[] sites = gson.fromJson(res, MangaSite[].class);

                return sites;

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(MangaSite[] sites) {
            TextView tvContent = (TextView) findViewById(R.id.textView_content);
            tvContent.setText(sites[2].siteId);
        }

    }
}
