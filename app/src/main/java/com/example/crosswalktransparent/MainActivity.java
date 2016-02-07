package com.example.crosswalktransparent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.xwalk.core.XWalkView;

public class MainActivity extends AppCompatActivity {
    private XWalkView xWalkWebView;
//    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xWalkWebView =(XWalkView)findViewById(R.id.xwalkWebView);
        xWalkWebView.setBackgroundColor(Color.TRANSPARENT);
        xWalkWebView.load("file:///android_asset/www/index.html\n", null);

//        webView = (WebView) findViewById(R.id.webView);
//        webView.setBackgroundColor(0);
//        webView.loadUrl("file:///android_asset/www/index.html\n");
    }
}
