package com.example.rayanet.tarahi;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources = {R.drawable.tuti1,R.drawable.tuti2,R.drawable.tuti3,R.drawable.tuti4};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View  item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.c);
        TextView textView = (TextView) item_view.findViewById(R.id.b);
        Picasso.get().load(image_resources[position]).resize(200,100).into(imageView);
        textView.setText("Image : +position");
        container.addView(item_view);
        return item_view;


        //dorost shod
        //hessa

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
