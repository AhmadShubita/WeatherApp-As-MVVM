package com.example.weather.view.adapter;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.weather.utils.AppConstant;
import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class CustomBindingAdapter {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(CircleImageView view, String url) {
        Picasso.get().load(AppConstant.FLAG_URL+url+".png").fit().into(view);
    }
}