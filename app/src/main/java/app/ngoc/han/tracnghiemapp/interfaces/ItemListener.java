package app.ngoc.han.tracnghiemapp.interfaces;

import android.view.View;

/**
 * Created by hai.tran on 11/8/2016.
 */

public interface ItemListener {
    void onItemClicked(View view, int position);

    boolean onItemLongClicked(View view, int position);
}
