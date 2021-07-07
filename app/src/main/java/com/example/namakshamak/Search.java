package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Search extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        webView=findViewById(R.id.webview);
        String searchline=getIntent().getExtras().getString("searchline");
        String[] a = searchline.split( " " );
        String url="https://www.allrecipes.com/search/results/?search=";
        String newurl=url;

        for (String a1 : a){
            newurl= newurl + a1 +"+";
        }
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://" +newurl);
    }
}