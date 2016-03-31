package com.example.crosswalktransparent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

public class MainActivity extends AppCompatActivity {
    private XWalkView xWalkWebView;
//    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);

        ViewGroup rootLayout = (ViewGroup) findViewById(R.id.container);
        xWalkWebView = new XWalkView(this);
        xWalkWebView.setBackgroundColor(Color.TRANSPARENT);
        xWalkWebView.load("file:///android_asset/www/index.html\n", null);
        rootLayout.addView(xWalkWebView);

        xWalkWebView.setBackgroundColor(Color.TRANSPARENT);
        TextureView tuv = findXWalkTextureView(xWalkWebView);
        tuv.setOpaque(false);
    }

    private TextureView findXWalkTextureView(ViewGroup group) {
        int childCount = group.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = group.getChildAt(i);
            if (child instanceof TextureView) {
                String parentClassName = child.getParent().getClass().toString();
                boolean isRightKindOfParent = (parentClassName.contains("XWalk"));
                if (isRightKindOfParent)
                { return (TextureView) child; }
            } else if (child instanceof ViewGroup) {
                TextureView textureView = findXWalkTextureView((ViewGroup) child);
                if (textureView != null)
                { return textureView; }
            }
        }
        return null;
    }
}
