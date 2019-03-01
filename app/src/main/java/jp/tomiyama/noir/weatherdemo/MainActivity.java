package jp.tomiyama.noir.weatherdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public String myId = "560565efd16ecd03e4fa586ec6aed1f4";
    public String lat = "34";
    public String lon = "135";
    public String cnt = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService mService = mRetrofit.create(ApiService.class);

        Call<Weather> mCall = mService.getWeather(lat,lon,cnt,myId);

        mCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                Log.d("test","ok");

                Weather weather = response.body();

                if(weather!=null){
                    Log.d("weather.cod",weather.getCod());
                }

            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("test", String.valueOf(t));

            }
        });
    }
}
