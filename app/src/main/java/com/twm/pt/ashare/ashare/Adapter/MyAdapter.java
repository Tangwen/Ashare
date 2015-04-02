package com.twm.pt.ashare.ashare.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.twm.pt.ashare.ashare.ImageViewHelper;
import com.twm.pt.ashare.ashare.R;
import com.twm.pt.ashare.ashare.component.ShareDetail;

import java.util.ArrayList;

/**
 * Created by TangWen on 2015/3/23.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<ShareDetail> shareDetailArray;
    private Context mContext;
    private ArrayList<View.OnClickListener> mListener = new ArrayList<View.OnClickListener> ();
    private int setFullSpanPosition = -1;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener  {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mText1View;
        public TextView mText2View;
        public TextView mText3View;
        public TextView mText4View;
        public CardView cardViewT;
        public Button mButton1;
        public Button mButton2;
        public RecyclerView mRecyclerView;
        public LinearLayout mInfoLayout;
        public FrameLayout idhr;

        public PicAdapter picAdapter;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemLayoutView.setOnClickListener(this);
            mImageView = (ImageView) itemLayoutView.findViewById(R.id.info_image);
            mText1View = (TextView) itemLayoutView.findViewById(R.id.info1_text);
            mText2View = (TextView) itemLayoutView.findViewById(R.id.info2_text);
            mText3View = (TextView) itemLayoutView.findViewById(R.id.info3_text);
            mText4View = (TextView) itemLayoutView.findViewById(R.id.info4_text);
            cardViewT = (CardView) itemLayoutView.findViewById(R.id.card_view);
            mButton1 = (Button) itemLayoutView.findViewById(R.id.button1);
            mButton2 = (Button) itemLayoutView.findViewById(R.id.button2);
            mRecyclerView = (RecyclerView) itemLayoutView.findViewById(R.id.pic_recycler_view);
            mInfoLayout = (LinearLayout) itemLayoutView.findViewById(R.id.info_layout);
            idhr = (FrameLayout) itemLayoutView.findViewById(R.id.idhr);

            mButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(view.getContext(), "Button position = " + getPosition() + ", " + getLayoutPosition() + ", " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    try {
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(shareDetailArray.get(getLayoutPosition()).documentUrl));
                        mContext.startActivity(myIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(view.getContext(), "Button position = " + getPosition() + ", " + getLayoutPosition() + ", " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    try {
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(shareDetailArray.get(getLayoutPosition()).apkUrl));
                        mContext.startActivity(myIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            StaggeredGridLayoutManager mStaggeredGridLayoutManager =new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
            picAdapter = new PicAdapter(mContext, new ArrayList<String>());
            mRecyclerView.setAdapter(picAdapter);
        }

        @Override
        public void onClick(View view) {
            if(setFullSpanPosition == getLayoutPosition()) {
                setFullSpanPosition = -1;
            } else {
                setFullSpanPosition = getLayoutPosition();
            }
            notifyDataSetChanged();
//            Toast.makeText(view.getContext(), "position = " + getPosition() + ", " + getLayoutPosition() + ", " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            for (View.OnClickListener listener: mListener) {
                view.setTag(getLayoutPosition());
                listener.onClick(view);
            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<ShareDetail> shareDetailArray) {
        mContext = context;
        this.shareDetailArray = shareDetailArray;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.share_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        ShareDetail mShareDetail = shareDetailArray.get(position);
        Picasso.with(mContext).load(mShareDetail.sharePicUrl).placeholder(R.drawable.progress_animation).into(holder.mImageView);
        holder.mText1View.setText(mShareDetail.itemName);
        holder.mText2View.setText("by " + mShareDetail.shareName);
        holder.mText3View.setText("  (" + mShareDetail.shareDate + ")");
        holder.mText4View.setText(mShareDetail.description);
        holder.picAdapter.setPicUrlArray(mShareDetail.picUrlArray);
        holder.picAdapter.notifyDataSetChanged();
        if(mShareDetail.documentUrl!=null) {
            holder.mButton1.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.download1, 0, 0, 0);
        } else {
            holder.mButton1.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.close_icon, 0, 0, 0);
        }
        if(mShareDetail.apkUrl!=null) {
            holder.mButton2.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.download, 0, 0, 0);
        } else {
            holder.mButton2.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.close_icon, 0, 0, 0);
        }


        //一格畫面
        final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
            if(position==setFullSpanPosition) {
                sglp.setFullSpan(true);
                holder.mText4View.setVisibility(View.VISIBLE);
                holder.mButton1.setVisibility(View.VISIBLE);
                holder.mButton2.setVisibility(View.VISIBLE);
                holder.mInfoLayout.setOrientation(LinearLayout.HORIZONTAL);
                holder.idhr.setVisibility(View.VISIBLE);
                if(mShareDetail.picUrlArray.size()>0) {
                    holder.mRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    holder.mRecyclerView.setVisibility(View.GONE);
                }
            } else {
                sglp.setFullSpan(false);
                holder.mText4View.setVisibility(View.GONE);
                holder.mButton1.setVisibility(View.GONE);
                holder.mButton2.setVisibility(View.GONE);
                holder.mInfoLayout.setOrientation(LinearLayout.VERTICAL);
                holder.idhr.setVisibility(View.GONE);
                holder.mRecyclerView.setVisibility(View.GONE);
            }
            holder.itemView.setLayoutParams(sglp);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return shareDetailArray.size();
    }

    public void addOnClickListener(View.OnClickListener mListener) {
        this.mListener.add(mListener);
    }

    public void setShareDetailArray(ArrayList<ShareDetail> shareDetailArray) {
        this.shareDetailArray = shareDetailArray;
    }
}
