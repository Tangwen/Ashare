package com.twm.pt.ashare.ashare;

import com.twm.pt.ashare.ashare.component.ShareClassType;
import com.twm.pt.ashare.ashare.component.ShareDetail;

import java.util.ArrayList;

/**
 * Created by TangWen on 2015/3/25.
 */
public class ShareDoc {

    private static ShareDoc mShareDoc;
    public static ShareDoc getInstance() {
        if(mShareDoc==null) {
            mShareDoc = new ShareDoc();
        }
        return mShareDoc;
    }
    public ArrayList<ShareDetail> getShareDetailArray() {

        ArrayList<ShareDetail> shareDetailArray = new ArrayList<ShareDetail>();
        shareDetailArray.add(getMProjectIssuesLessonsLearned());
        shareDetailArray.add(getDynamicAnalyzingSystem());
        shareDetailArray.add(getParallaxHeaderViewPager());
        shareDetailArray.add(getShareDetail_AndEngine());
        shareDetailArray.add(getShareDetail_CPUarchitectures());
//        shareDetailArray.add(getTestShareDetail("itemName0"));
//        shareDetailArray.add(getTestShareDetail("itemName1"));
//        shareDetailArray.add(getTestShareDetail("itemName2"));
//        shareDetailArray.add(getTestShareDetail("itemName3"));
//        shareDetailArray.add(getTestShareDetail("itemName4"));
//        shareDetailArray.add(getTestShareDetail("itemName5"));
//        shareDetailArray.add(getTestShareDetail("itemName6"));
//        shareDetailArray.add(getTestShareDetail("itemName7"));
//        shareDetailArray.add(getTestShareDetail("itemName8"));
//        shareDetailArray.add(getTestShareDetail("itemName9"));

        return shareDetailArray;
    }

    public ArrayList<ShareDetail> getShareDetailArray(ShareClassType shareClassType) {
        ArrayList<ShareDetail> shareDetailArray = new ArrayList<ShareDetail>();
        ArrayList<ShareDetail> shareDetailArrayTemp = getShareDetailArray();
        if(shareClassType==null) {
            return shareDetailArrayTemp;
        }
        for(ShareDetail shareDetail: shareDetailArrayTemp) {
            if(shareDetail.shareClass.contains(shareClassType)) {
                shareDetailArray.add(shareDetail);
            }
        }
        return shareDetailArray;
    }


    private ShareDetail getMProjectIssuesLessonsLearned() {
        String itemName = "M+ Project issues Lessons Learned";
        String shareName = "Sometimes Li";
        String sharePicUrl = "https://lh4.ggpht.com/es1CB3SGshxDV_f26zyv4S_42T9x-U0f3g_diVsgf-2f8Jr75UphamR6EWjbZfaHqiE=w300-rw";
        String shareDate = "2015/03";
        String description = "Case 1 螢幕鎖的控制\n" +
                "Case 2 螢幕鎖之上\n" +
                "Case 3 背景處理的逆襲運作模式";
        String documentUrl = "https://drive.google.com/file/d/0BzMBkWeyBi5Zc21kSnAxTUt0bGRZYXcyZkFpWnM0SDYwNGpr/view?usp=sharing";
        String apkUrl = null;
        ArrayList<String> picUrl = new ArrayList<String>();
        ShareDetail shareDetail = new ShareDetail(itemName, shareName, sharePicUrl, shareDate, description, documentUrl, apkUrl, picUrl);
        shareDetail.addShareClass(ShareClassType.FUNCTIONS);
        shareDetail.addShareClass(ShareClassType.PERFORMANCE);

        return shareDetail;
    }





    private ShareDetail getDynamicAnalyzingSystem() {
        String itemName = "Malicious Android AppDynamic Analyzing System";
        String shareName = "Brent";
        String sharePicUrl = "http://www.blogcdn.com/www.engadget.com/media/2011/03/market-bag-gun.jpg";
        String shareDate = "2015/03";
        String description = "藉由重新編譯過的ROM，針對APP進行動態分析，查看是否存在惡意資訊";
        String documentUrl = "http://www.slideshare.net/erinus/android-security-development-45870056";
        String apkUrl = null;
        ArrayList<String> picUrl = new ArrayList<String>();
        picUrl.add("http://image.slidesharecdn.com/androidsecuritydevelopment-150315222311-conversion-gate01/95/android-security-development-part-2-malicious-android-appdynamic-analyzing-system-1-638.jpg?cb=1426476332");
        picUrl.add("http://image.slidesharecdn.com/androidsecuritydevelopment-150315222311-conversion-gate01/95/android-security-development-part-2-malicious-android-appdynamic-analyzing-system-24-638.jpg?cb=1426476332");
        picUrl.add("http://image.slidesharecdn.com/androidsecuritydevelopment-150315222311-conversion-gate01/95/android-security-development-part-2-malicious-android-appdynamic-analyzing-system-49-638.jpg?cb=1426476332");
        ShareDetail shareDetail = new ShareDetail(itemName, shareName, sharePicUrl, shareDate, description, documentUrl, apkUrl, picUrl);
        shareDetail.addShareClass(ShareClassType.TOOLS);
        shareDetail.addShareClass(ShareClassType.SAFE);

        return shareDetail;
    }

    private ShareDetail getParallaxHeaderViewPager() {
        String itemName = "Parallax Header ViewPager";
        String shareName = "Ivan Lu";
        String sharePicUrl = "https://lh4.ggpht.com/JddlElWkY8bbqb2SszQi6nUyJFLV9OTmp0GGH78L93M6X3JFm9KyegkOjYImXPAf_2w=w300-rw";
        String shareDate = "2015/01";
        String description = "1. Action bar with Pager UI\n" +
                "2.Base on other libraries : \n" +
                " \t a. NotBoringActionBar\n" +
                " \t b. KenBurnsSupportView\n" +
                " \t c. PagerSlidingTabStrip\n" +
                " \t d. NineOldAndroids\n" +
                "3. support v7 Appcompat – for actionbar";
        String documentUrl = "https://drive.google.com/open?id=0BzMBkWeyBi5ZUDhSYWR4MFlEcFNoYUNSTG5oY0xOOHZUeVYw&authuser=0";
        String apkUrl = "https://github.com/kmshack/Android-ParallaxHeaderViewPager";
        ArrayList<String> picUrl = new ArrayList<String>();
        ShareDetail shareDetail = new ShareDetail(itemName, shareName, sharePicUrl, shareDate, description, documentUrl, apkUrl, picUrl);
        picUrl.add("https://lh6.ggpht.com/dMn5gTR78NtLsBY4BS7Sok6zr_qiGPv_CxDN1bKFquAdhQfV7_TJ5Bq5ltVpMwr27I0=h310-rw");
        picUrl.add("https://lh3.ggpht.com/hTh6QUuCDiAEgWebl4BDZ0tn7f-nq96X_GVZttxK-BeodVOC-dM4tYfMCzIvTHvKYgs=h310-rw");
        picUrl.add("https://camo.githubusercontent.com/0a791ff6de887022f555df0b4ee8bb1bb9adaa0f/68747470733a2f2f7261772e6769746875622e636f6d2f6279646176792f616e64726f69642d706172616c6c61782d6578616d706c652f6d61737465722f70726573656e746174696f6e2f73637265656e73686f745f312e706e67");
        picUrl.add("https://camo.githubusercontent.com/87bb05fc1396760c3c5a7df94ac0bae6e3c020e1/68747470733a2f2f7261772e6769746875622e636f6d2f6279646176792f616e64726f69642d706172616c6c61782d6578616d706c652f6d61737465722f70726573656e746174696f6e2f73637265656e73686f745f322e706e67");
        picUrl.add("http://nineoldandroids.com/screens.png");
        shareDetail.addShareClass(ShareClassType.TOOLS);
        shareDetail.addShareClass(ShareClassType.UI);

        return shareDetail;
    }



    private ShareDetail getShareDetail_AndEngine() {
        String itemName = "AndEngine - PhysicsBox2DExtension.";
        String shareName = "Kris";
        String sharePicUrl = "http://www.andengine.org/images/logo.png";
        String shareDate = "2014/12";
        String description = "AndEngine 是一款以 OpenGLES 方式進行畫面渲染的 Android 2D 遊戲引擎，可運行在 Android 1.6 及以上版本的系統當中，預設可支援中文且所採用的螢幕座標系統也符合一般 Android 的繪圖習慣。";
        String documentUrl = "http://www.andengine.org/blog/";
        String apkUrl = "https://play.google.com/store/apps/details?id=org.anddev.andengine.examples";
        ArrayList<String> picUrl = new ArrayList<String>();
        picUrl.add("http://www.andengine.org/blog/wp-content/uploads/2013/01/andengine_cookbook_jayme_schroeder.jpeg");
        picUrl.add("https://lh6.ggpht.com/zmCTAfkUtJg_ySgNPCHNlDRtK8QYqMiBmJHR23ptKxjHWL4uNyF7X0_xh6NvBO6wndY=h310-rw");
        picUrl.add("https://lh4.ggpht.com/7uO0AxYwaa_2q8AF2Dyq5PPxabRQ0zB8R1-q9x_7ieEyIH_2KYdkkk04iXbmmRzu73U=h310-rw");
        ShareDetail shareDetail = new ShareDetail(itemName, shareName, sharePicUrl, shareDate, description, documentUrl, apkUrl, picUrl);
        shareDetail.addShareClass(ShareClassType.TOOLS);
        shareDetail.addShareClass(ShareClassType.UI);
        shareDetail.addShareClass(ShareClassType.PERFORMANCE);

        return shareDetail;
    }


    private ShareDetail getShareDetail_CPUarchitectures() {
        String itemName = "如何判斷是否使用cpu種類(multiple CPU architectures)";
        String shareName = "Bear";
        String sharePicUrl = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTpZ0Uu1VIR5o8cC0FgIA1rgozTgbeZAMIMp-H9t2ZTM-dcaelKnw";
        String shareDate = "2014/12";
        String description = "Getting Started on Optimizing NDK project for multiple CPU architectures";
        String documentUrl = "https://software.intel.com/en-us/android/articles/getting-started-on-optimizing-ndk-project-for-multiple-cpu-architectures";
        String apkUrl = "https://software.intel.com/sites/default/files/CPU_Features_Check.zip";
        ArrayList<String> picUrl = new ArrayList<String>();
        picUrl.add("https://software.intel.com/sites/default/files/8878-f1.jpg");
        ShareDetail shareDetail = new ShareDetail(itemName, shareName, sharePicUrl, shareDate, description, documentUrl, apkUrl, picUrl);
        shareDetail.addShareClass(ShareClassType.TOOLS);
        shareDetail.addShareClass(ShareClassType.PERFORMANCE);

        return shareDetail;
    }


    private ShareDetail getTestShareDetail(String itemNameIN) {
        String itemName = itemNameIN;
        String shareName = "shareName";
        String sharePicUrl = "http://www.cadtc.com.tw/blog/uploads/02-android-vs-ios.jpg";
        String shareDate = "yyyy/MM";
        String description = "3";
        String documentUrl = "https://drive.google.com/file/d/0BzMBkWeyBi5ZYlUxLU5IbWx2dTVVSTFDM0tqWnVYLUcxOUJF/view?usp=sharing";
        String apkUrl =null;
        ArrayList<String> picUrl = new ArrayList<String>();
        picUrl.add("pic1");
        picUrl.add("pic2");
        ShareDetail shareDetail = new ShareDetail(itemName, shareName, sharePicUrl, shareDate, description, documentUrl, apkUrl, picUrl);
        return shareDetail;
    }
}
