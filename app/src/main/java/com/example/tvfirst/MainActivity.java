package com.example.tvfirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.Timer;

/**
 * Created by User on 26.02.2016.
 */
public class MainActivity extends Activity {
    TextView textView;
    public final static String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBmSXUzVZBKQv9FJkTpZXn0dObKgEQOIFU&cx=014099860786446192319:t5mr0xnusiy&q=AndroidDev&alt=json&searchType=image";
    public final static String url1 ="http://www.example.com";

    RequestQueue requestQueue;
    JsonObjectRequest jsObjRequest;
    public final static int GET = 0;
    ImageRequest imageRequest;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my);

        Cache cache = new DiskBasedCache(getApplicationContext().getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);

        requestQueue.start();
        //textView = (TextView) findViewById(R.id.textViewHello);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("ОТВЕТ ПОЛУЧЕН+++");
            }
        }, errorListener);


//         RequestQueue requestQueue = MySingleton.getInstance(getApplicationContext()).getRequestQueue();
//         MySingleton.getInstance(getApplicationContext()).addToRequestQueue(imageRequest);
//         MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        //jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, "", jsonObjectListener, errorListener);

    }


    Response.Listener<JSONObject> jsonObjectListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            textView.setText("response");
            requestQueue.stop();
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText("error " + error.getStackTrace().toString());
            requestQueue.stop();
        }
    };

    public void handleClick(View v)
    {
        String str = null;
        switch (v.getId())
        {
            case R.id.button1:
                str = getResources().getString(R.string.first_text);
                requestQueue.add(jsObjRequest);
                break;
            case R.id.button2:
                str = getResources().getString(R.string.second_text);
                MyAsync myAsync = new MyAsync();
                myAsync.textView = this.textView;
                myAsync.execute("");

                break;
            case R.id.button3:
                str = getResources().getString(R.string.third_text);
                break;
            default:
                str = "not right";
                break;
        }
        textView.setText(str);
    }
}
