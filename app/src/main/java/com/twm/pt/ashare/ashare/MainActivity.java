package com.twm.pt.ashare.ashare;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.twm.pt.ashare.ashare.Adapter.MyAdapter;
import com.twm.pt.ashare.ashare.component.ShareClassType;


public class MainActivity extends ActionBarActivity {

    private Toolbar mToolbar;
    private DrawerLayout layDrawer;
    private RecyclerView mRecyclerView;
    private ListView mListView;
    private MyAdapter mAdapter;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle, mTitleTemp;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = this;

        initDrawerLayout();
        initDrawerList();
        initContentLayout();
    }



    private void initDrawerLayout(){
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        layDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.share_list_recycler_view);
        mListView = (ListView) findViewById(R.id.left_list_view);
        mTitle = mTitleTemp = getResources().getString(R.string.title_text);
        mDrawerTitle = getResources().getString(R.string.drawer_Title);
        mToolbar.setTitle(mTitle);

        drawerToggle = new ActionBarDrawerToggle(
                this,
                layDrawer,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                mToolbar.setTitle(mTitle);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mToolbar.setTitle(mDrawerTitle);
            }
        };
        drawerToggle.syncState();

        layDrawer.setDrawerListener(drawerToggle);
    }

    private void initDrawerList() {
//        String[] drawer_menu = this.getResources().getStringArray(R.array.drawer_menu);
        String[] drawer_menu = ShareClassType.getStringNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawer_menu);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mTitle = mTitleTemp + "(" + (adapterView.getItemAtPosition(i).toString()) + ")";
                ShareClassType shareClassType = ShareClassType.lookup(adapterView.getItemAtPosition(i).toString());
                mAdapter.setShareDetailArray(ShareDoc.getInstance().getShareDetailArray(shareClassType));
                mAdapter.notifyDataSetChanged();
                layDrawer.closeDrawers();
            }
        });
    }


    private void initContentLayout() {

        mRecyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager mStaggeredGridLayoutManager =new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        mAdapter = new MyAdapter(this, ShareDoc.getInstance().getShareDetailArray());
        mAdapter.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int pos = (int)view.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
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
