package com.twm.pt.ashare.ashare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.twm.pt.ashare.ashare.R;

import java.util.ArrayList;

/**
 * Created by TangWen on 2015/3/23.
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.ViewHolder> {

    private  ArrayList<String> picUrlArray;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener  {
        // each data item is just a string in this case
        public ImageView mImageView;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemLayoutView.setOnClickListener(this);
            mImageView = (ImageView) itemLayoutView.findViewById(R.id.pic_image);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position = " + getPosition() + ", " + getLayoutPosition() + ", " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PicAdapter(Context context, ArrayList<String> picUrlArray) {
        mContext = context;
        this.picUrlArray = picUrlArray;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pic_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PicAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        String picUrl = picUrlArray.get(position);
        Picasso.with(mContext).load(picUrl).into(holder.mImageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return picUrlArray.size();
    }

    public ArrayList<String> getPicUrlArray() {
        return picUrlArray;
    }
    public void setPicUrlArray(ArrayList<String> picUrlArray) {
        this.picUrlArray = picUrlArray;
    }
}
