package com.wpf.tabview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 王朋飞 on 7-19-0019.
 * 标签View
 */

public class TabView extends LinearLayout {

    private ImageView imageView;
    private TextView textView;

    public TabView(Context context) {
        this(context,null);
    }

    public TabView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.view_tab,this,false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        textView = (TextView) view.findViewById(R.id.textView);
        setBackColor(Color.GRAY);
        addView(view);
        setElevation();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setElevation() {
        setElevation(3);
        setTranslationZ(2);
    }

    public TabView setBackColor(int color) {
        GradientDrawable shapeDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.back_tab);
        shapeDrawable.setColor(color);
        setBackground(shapeDrawable);
        return this;
    }

    public TabView setImageView(Drawable drawable) {
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(VISIBLE);
        return this;
    }

    public TabView setImageView(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(VISIBLE);
        return this;
    }

    public TabView setText(String text) {
        textView.setText(text);
        return this;
    }

    public TabView setTextColor(int color) {
        textView.setTextColor(color);
        return this;
    }

    public String getText() {
        return textView.getText().toString();
    }
}
