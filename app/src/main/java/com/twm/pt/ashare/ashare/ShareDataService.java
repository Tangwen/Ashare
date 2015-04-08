package com.twm.pt.ashare.ashare;

import com.twm.pt.ashare.ashare.component.ShareDetail;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by TangWen on 2015/4/8.
 */
public interface ShareDataService {
    @GET("/webapps/ashare/{filename}")
    ArrayList<ShareDetail> getShareDetailArray_GET(@Path("filename") String filename);

    @GET("/webapps/ashare/{filename}")
    void getShareDetailArray_GETcb(@Path("filename") String filename, Callback<ArrayList<ShareDetail>> cb);

}
