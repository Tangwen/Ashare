package com.twm.pt.ashare.ashare.component;

import java.util.ArrayList;

public class ShareDetail {
    /** 分享主題 */
    public String itemName;
    /** 分享者 */
    public String shareName;
    /** 分享畫面*/
    public String sharePicUrl;
    /** 分享日期 yyyy/MM*/
    public String shareDate;
    /** 簡述說明 */
    public String description;
    /** 說明文件連結 */
    public String documentUrl;
    /** Demo APK下載連結 */
    public String apkUrl;
    /** Demo 圖片連結 */
    public ArrayList<String> picUrlArray = new ArrayList<String>();

    /** 類別 */
    public ArrayList<ShareClassType> shareClass = new ArrayList<ShareClassType>();


    public ShareDetail(String itemName, String shareName, String sharePicUrl, String shareDate,
                       String description, String documentUrl, String apkUrl,
                       ArrayList<String> picUrl) {
        super();
        this.itemName = itemName;
        this.shareName = shareName;
        this.sharePicUrl = sharePicUrl;
        this.shareDate = shareDate;
        this.description = description;
        this.documentUrl = documentUrl;
        this.apkUrl = apkUrl;
        this.picUrlArray = picUrl;
        this.shareClass.add(ShareClassType.ALL);
    }

    public ArrayList<ShareClassType> getShareClass() {
        return shareClass;
    }
    public void setShareClass(ArrayList<ShareClassType> shareClass) {
        this.shareClass = shareClass;
    }
    public void addShareClass(ShareClassType shareClassType) {
        this.shareClass.add(shareClassType);
    }
    public void removeShareClass(ShareClassType shareClassType) {
        this.shareClass.remove(shareClassType);
    }
}
