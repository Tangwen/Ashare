package com.twm.pt.ashare.ashare;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.twm.pt.ashare.ashare.Adapter.MyAdapter;
import com.twm.pt.ashare.ashare.Adapter.PicAdapter;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
//    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private ImageView mImageView;
    private MyAdapter mAdapter;
//    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mImageView = (ImageView) findViewById(R.id.test_image);


//        mImageView.setDrawingCacheEnabled(true);
//        DisplayMetrics dm = this.getResources().getDisplayMetrics();
//        new ImageViewHelper(dm, mImageView, null).setBitmapWidthHeight(576,72);

//        Picasso.with(getApplicationContext()).load("http://pagead2.googlesyndication.com/simgad/17966329567249548074").into(mImageView);
//        Picasso.with(getApplicationContext()).load("http://www.cadtc.com.tw/blog/uploads/02-android-vs-ios.jpg").into(mImageView);
//        Picasso.with(getApplicationContext()).load("http://static.webhek.com/techug-res/uploads/2015/02/learn-android-development.jpg").into(mImageView);
        Picasso.with(getApplicationContext()).load("http://t1.gstatic.com/images?q=tbn:ANd9GcT_PPy7gnJBYKwnGJl16UQRZFvKUq6PenzvQoLzxRkeelIIOVge").into(mImageView);




        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(mLayoutManager);
        StaggeredGridLayoutManager mStaggeredGridLayoutManager =new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this, ShareDoc.getInstance().getShareDetailArray());
        mAdapter.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "position = " + view.getTag(), Toast.LENGTH_SHORT).show();
                //Intent in = new Intent(getApplicationContext(),DetailPage.class);
                //startActivity(in);
                try {
                    int pos = (int)view.getTag();
                    //mRecyclerView.smoothScrollToPosition(pos);
                    //mStaggeredGridLayoutManager.scrollToPosition(pos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

//        StaggeredGridLayoutManager mStaggeredGridLayoutManager =new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
//        mAdapter = new PicAdapter(this, ShareDoc.getInstance().getShareDetailArray().get(0).picUrlArray);
//        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
