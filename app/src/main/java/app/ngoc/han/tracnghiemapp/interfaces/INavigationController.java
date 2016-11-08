package app.ngoc.han.tracnghiemapp.interfaces;

import android.content.Context;
import android.support.v4.app.Fragment;


public interface INavigationController {
    void openActivity(Context packerContext, Class<?> activityToOpen);

    void openNewFragment(int resId, Fragment fragment);

    void replaceFragment(int resId, Fragment fragment);

    void clearAllBackStack();
}
