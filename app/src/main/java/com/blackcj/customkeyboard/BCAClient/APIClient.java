package com.blackcj.customkeyboard.BCAClient;

import android.util.Log;

import com.blackcj.customkeyboard.MutasiItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIClient {
    private String baseURL = "http://182.16.165.88/";

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public String downloadString(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        Log.d("asa", url);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public MutasiResponse getMutasi() throws IOException {
        String raw = this.downloadString(this.baseURL.concat("transaction/?account=8220000053"));
        Type responseType = new TypeToken<MutasiResponse>(){}.getType();
        Log.d("Sheeet", raw);
        return new Gson().fromJson(raw, responseType);
    }
}