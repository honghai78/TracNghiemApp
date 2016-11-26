package app.ngoc.han.tracnghiemapp.models;

/**
 * Created by NONG on 14-11-2016.
 */
public class LyThuyet {
    private String mTenThi;
    private String[] mForm;
    private String[] mUsage;
    private String[] mDauHieu;

    public LyThuyet(String mTenThi, String[] mForm, String[] mUsage, String[] mDauHieu) {
        this.mTenThi = mTenThi;
        this.mForm = mForm;
        this.mUsage = mUsage;
        this.mDauHieu = mDauHieu;
    }

    public String getmTenThi() {
        return mTenThi;
    }

    public void setmTenThi(String mTenThi) {
        this.mTenThi = mTenThi;
    }

    public String[] getmForm() {
        return mForm;
    }

    public void setmForm(String[] mForm) {
        this.mForm = mForm;
    }

    public String[] getmUsage() {
        return mUsage;
    }

    public void setmUsage(String[] mUsage) {
        this.mUsage = mUsage;
    }

    public String[] getmDauHieu() {
        return mDauHieu;
    }

    public void setmDauHieu(String[] mDauHieu) {
        this.mDauHieu = mDauHieu;
    }
}
