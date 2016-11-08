package app.ngoc.han.tracnghiemapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hai.tran on 11/8/2016.
 */

public class TitleTest implements Parcelable {

    /**
     * id : 1
     * image_link :
     * name : Thì Hiện tại đơn
     */

    @SerializedName("id")
    private int id;
    @SerializedName("image_link")
    private String imageLink;
    @SerializedName("name")
    private String name;

    public static TitleTest objectFromData(String str) {

        return new Gson().fromJson(str, TitleTest.class);
    }

    public static TitleTest objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), TitleTest.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<TitleTest> arrayTitleTestFromData(String str) {

        Type listType = new TypeToken<ArrayList<TitleTest>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<TitleTest> arrayTitleTestFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            Type listType = new TypeToken<ArrayList<TitleTest>>() {
            }.getType();

            return new Gson().fromJson(jsonArray.toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.imageLink);
        dest.writeString(this.name);
    }

    public TitleTest() {
    }

    protected TitleTest(Parcel in) {
        this.id = in.readInt();
        this.imageLink = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<TitleTest> CREATOR = new Parcelable.Creator<TitleTest>() {
        @Override
        public TitleTest createFromParcel(Parcel source) {
            return new TitleTest(source);
        }

        @Override
        public TitleTest[] newArray(int size) {
            return new TitleTest[size];
        }
    };
}
