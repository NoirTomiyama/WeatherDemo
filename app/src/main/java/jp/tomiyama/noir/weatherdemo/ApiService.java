package jp.tomiyama.noir.weatherdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // 一旦挙動のためにString型に変更した．floatでも問題ないかと！

    @GET("/data/2.5/forecast?")
    Call<Weather> getWeather(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("cnt") String cnt,
            @Query("appid") String appId
    );

}
