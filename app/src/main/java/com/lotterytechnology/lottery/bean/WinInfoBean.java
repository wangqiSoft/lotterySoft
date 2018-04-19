package com.lotterytechnology.lottery.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Ryder
 * create at 2018/4/19 16:42
 * package name:com.lotterytechnology.lottery.bean
 * description:
 **/
public class WinInfoBean implements Parcelable {
    private String id;
    private String betAmt; //投注
    private String createTime;
    private String gameName;
    private String link;
    private String platform;
    private String prize;
    private String prizeTime;
    private int status;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(String betAmt) {
        this.betAmt = betAmt;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(String prizeTime) {
        this.prizeTime = prizeTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "WinInfoBean{" +
                "id='" + id + '\'' +
                ", betAmt='" + betAmt + '\'' +
                ", createTime='" + createTime + '\'' +
                ", gameName='" + gameName + '\'' +
                ", link='" + link + '\'' +
                ", platform='" + platform + '\'' +
                ", prize='" + prize + '\'' +
                ", prizeTime='" + prizeTime + '\'' +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.betAmt);
        dest.writeString(this.createTime);
        dest.writeString(this.gameName);
        dest.writeString(this.link);
        dest.writeString(this.platform);
        dest.writeString(this.prize);
        dest.writeString(this.prizeTime);
        dest.writeInt(this.status);
        dest.writeString(this.userName);
    }

    public WinInfoBean() {
    }

    protected WinInfoBean(Parcel in) {
        this.id = in.readString();
        this.betAmt = in.readString();
        this.createTime = in.readString();
        this.gameName = in.readString();
        this.link = in.readString();
        this.platform = in.readString();
        this.prize = in.readString();
        this.prizeTime = in.readString();
        this.status = in.readInt();
        this.userName = in.readString();
    }

    public static final Creator<WinInfoBean> CREATOR = new Creator<WinInfoBean>() {
        @Override
        public WinInfoBean createFromParcel(Parcel source) {
            return new WinInfoBean(source);
        }

        @Override
        public WinInfoBean[] newArray(int size) {
            return new WinInfoBean[size];
        }
    };
}
