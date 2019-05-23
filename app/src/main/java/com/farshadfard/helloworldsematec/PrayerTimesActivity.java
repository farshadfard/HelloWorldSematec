package com.farshadfard.helloworldsematec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.farshadfard.helloworldsematec.PrayerTimesClasses.PrayerTimes;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PrayerTimesActivity extends AppCompatActivity implements OnItemClickListener {

    EditText edtCityName;
    Button btnSearch;
    RecyclerView rclSearchHistory;
    TextView txtSobh;
    TextView txtSunrise;
    TextView txtZohr;
    TextView txtSunset;
    TextView txtMaghreb;
    TextView txtMidnight;

    ArrayList<String> searchHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_times);

        BindViews();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (edtCityName.getText().toString() == "") {
                        Toast.makeText(PrayerTimesActivity.this, "لطفا نام شهر را وارد نمایید", Toast.LENGTH_LONG).show();
                        return;
                    }

                    String url = "http://api.aladhan.com/v1/timingsByCity?city=" + edtCityName.getText().toString() + "&country=Iran&method=8";
                    AsyncHttpClient client = new AsyncHttpClient();
                    client.get(url, new TextHttpResponseHandler() {
                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            Toast.makeText(PrayerTimesActivity.this, responseString, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, String responseString) {
                            Gson gson = new Gson();
                            PrayerTimes prayer = gson.fromJson(responseString, PrayerTimes.class);

                            txtSobh.setText("اذان صبح: " + prayer.getData().getTimings().getFajr());
                            txtSunrise.setText("طلوع آفتاب: " + prayer.getData().getTimings().getSunrise());
                            txtZohr.setText("اذان ظهر: " + prayer.getData().getTimings().getDhuhr());
                            txtSunset.setText("غروب آفتاب: " + prayer.getData().getTimings().getSunset());
                            txtMaghreb.setText("اذان مغرب: " + prayer.getData().getTimings().getMaghrib());
                            txtMidnight.setText("نیمه شب: " + prayer.getData().getTimings().getMidnight());


                            searchHistory.add(edtCityName.getText().toString());
                            SearchHistoryAdapter adapter = new SearchHistoryAdapter(searchHistory, PrayerTimesActivity.this);
                            rclSearchHistory.setAdapter(adapter);
                            rclSearchHistory.setLayoutManager(new LinearLayoutManager(PrayerTimesActivity.this, RecyclerView.HORIZONTAL, false));
                        }
                    });

                } catch (Exception ex) {
                    Toast.makeText(PrayerTimesActivity.this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void BindViews() {
        try {

            edtCityName = findViewById(R.id.edtCityName);
            btnSearch = findViewById(R.id.btnSearch);
            rclSearchHistory = findViewById(R.id.rclSearchHistory);
            txtSobh = findViewById(R.id.txtSobh);
            txtSunrise = findViewById(R.id.txtSunrise);
            txtZohr = findViewById(R.id.txtZohr);
            txtSunset = findViewById(R.id.txtSunset);
            txtMaghreb = findViewById(R.id.txtMaghreb);
            txtMidnight = findViewById(R.id.txtMidnight);

        } catch (Exception ex) {
            Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(String cityName) {
        edtCityName.setText(cityName);
        btnSearch.callOnClick();
    }
}
