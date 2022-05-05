package com.example.mcl.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mcl.R;


public class SliderPagerAdapter extends PagerAdapter {
    private Context context;
    public SliderPagerAdapter(Context context) {
        this.context = context;
    }
    private int[] slideImages = new int[]{
            R.drawable.bannear,
            R.drawable.bannear,
            // R.mipmap.live_tracking
    };
    @Override
    public int getCount() {
        return slideImages.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView mImageView = new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(slideImages[position]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}
