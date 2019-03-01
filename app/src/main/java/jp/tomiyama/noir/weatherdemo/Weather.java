package jp.tomiyama.noir.weatherdemo;

import com.google.gson.annotations.SerializedName;

public class Weather {

    // TODO 必要となるパラメータを定義してー！
    // @SerializedNameに注意
    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private float message;

    public String getCod() {
        return cod;
    }
}
