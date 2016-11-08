package app.ngoc.han.tracnghiemapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hai.tran on 11/8/2016.
 */

public class ScreenSize implements Parcelable {
    private int wight = 0, height = 0;

    public ScreenSize(int wight, int height) {
        this.wight = wight;
        this.height = height;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.wight);
        dest.writeInt(this.height);
    }

    protected ScreenSize(Parcel in) {
        this.wight = in.readInt();
        this.height = in.readInt();
    }

    public static final Parcelable.Creator<ScreenSize> CREATOR = new Parcelable.Creator<ScreenSize>() {
        @Override
        public ScreenSize createFromParcel(Parcel source) {
            return new ScreenSize(source);
        }

        @Override
        public ScreenSize[] newArray(int size) {
            return new ScreenSize[size];
        }
    };
}
