package com.twm.pt.ashare.ashare;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.twm.pt.ashare.ashare.Adapter.PicPagerAdapter;
import com.twm.pt.ashare.ashare.utility.L;

import java.util.ArrayList;


public class PicPageActivity extends Activity {

    private ViewPager mViewPager;
    private ArrayList<String> picUrlArray = new ArrayList<>();
    private int clickPos = 0;

    public PicPageActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        picUrlArray = (ArrayList<String>) getIntent().getSerializableExtra("picUrlArray");
        clickPos = getIntent().getIntExtra("clickPos", 0);

        L.d("picUrlArray.size()=" + picUrlArray.size());
        initDrawerLayout();
        initContentLayout();
    }


    private void initDrawerLayout(){
        setContentView(R.layout.pic_page);
        mViewPager = (ViewPager) findViewById(R.id.pager);
    }


    private void initContentLayout() {
        PicPagerAdapter mPicPagerAdapter = new PicPagerAdapter(this, picUrlArray);
        mViewPager.setAdapter(mPicPagerAdapter);
        mViewPager.setCurrentItem(clickPos);
    }

}
