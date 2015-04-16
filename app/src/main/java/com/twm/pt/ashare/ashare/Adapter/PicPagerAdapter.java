package com.twm.pt.ashare.ashare.Adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.twm.pt.ashare.ashare.R;
import com.twm.pt.ashare.ashare.utility.MulitPointTouchListener;

import java.util.ArrayList;

public class PicPagerAdapter extends PagerAdapter {
    Context mContext;
    ArrayList<String> picUrlArray = new ArrayList<>();
    LayoutInflater mLayoutInflater;
    int ScreenWidth, ScreenHeight;

    public PicPagerAdapter(Context context, ArrayList<String> picUrlArray) {
        mContext = context;
        this.picUrlArray = picUrlArray;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 取得螢幕顯示的資料
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        ScreenWidth = dm.widthPixels;
        ScreenHeight = dm.heightPixels;
    }

    @Override
    public int getCount() {
        return picUrlArray.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pic_page_detail, container, false);

        ImageView mImageView = (ImageView) itemView.findViewById(R.id.pic_detail_image);
        Picasso
                .with(mContext)
                .load(picUrlArray.get(position))
                .resize(ScreenWidth*9/10, ScreenHeight*9/10)
                .centerInside()
                .into(mImageView);
        mImageView.setOnTouchListener(new MulitPointTouchListener());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
