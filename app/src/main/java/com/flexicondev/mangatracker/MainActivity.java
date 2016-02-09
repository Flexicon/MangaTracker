package com.flexicondev.mangatracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    public void getData() {
//        try {
//            // Make request to API
//            HttpResponse<String> response = Unirest.get("https://doodle-manga-scraper.p.mashape.com/")
//                    .header("X-Mashape-Key", "nqtUYTVuRImshL0Fl8E1RWnORoSFp1B5Vi7jsnA8CPHWYfPXtl")
//                    .header("Accept", "text/plain")
//                    .asString();
//
//
//            // Keep response json
//            System.out.println(response.getBody());
//            String resJson = response.getBody();
//
//            Gson gson = new Gson();
//
//            MangaSite[] sites = gson.fromJson(resJson, MangaSite[].class);
//
//            Toast.makeText(getApplicationContext(), sites[0].siteId, Toast.LENGTH_LONG).show();
//
//        }
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {
        @Override
        protected Greeting doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
//                final String url = "http://jsonplaceholder.typicode.com/posts/1";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                Greeting greeting = restTemplate.getForObject(url, Greeting.class);
                return greeting;

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Greeting greeting) {
            TextView greetingIdText = (TextView) findViewById(R.id.textView_id);
            TextView greetingContentText = (TextView) findViewById(R.id.textView_content);
            greetingIdText.setText(greeting.getId());
            greetingContentText.setText(greeting.getContent());
//            greetingContentText.setText(greeting.getTitle());
        }

    }
}
