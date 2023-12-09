package com.example.lines;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.lines.model.Color;
import com.example.lines.model.Model;

import java.util.List;

public class ForecastAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] imageIds;

    public ForecastAdapter(Context c, Model model) {
        mContext = c;
        int size = Model.NEXT_COLORS_NUM;
        imageIds = new Integer[size];
        List<Color> nextColors = model.getNextColors();
        for (int i = 0; i < size; i++) {
            imageIds[i] = Utils.getFutureColorImage(nextColors.get(i));
        }
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return imageIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(98, 98));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageIds[position]);
        return imageView;
    }
}