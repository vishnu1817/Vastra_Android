package com.esolution.vastrashopper.ui.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.esolution.vastrabasic.utils.ImageUtils;
import com.esolution.vastrashopper.databinding.RowViewPagerBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    private RowViewPagerBinding binding;
    private final LayoutInflater layoutInflater;

    private final ArrayList<String> images;

    public ViewPagerAdapter(Context context, @NotNull ArrayList<String> images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        binding = RowViewPagerBinding.inflate(layoutInflater,container,false);
        View view = binding.getRoot();
        ImageUtils.loadImageUrl(binding.myViewPagerImage, images.get(position));
        Objects.requireNonNull(container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((LinearLayout) object);
    }
}
