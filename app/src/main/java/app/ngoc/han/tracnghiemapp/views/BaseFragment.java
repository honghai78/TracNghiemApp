package app.ngoc.han.tracnghiemapp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;


import app.ngoc.han.tracnghiemapp.R;
import app.ngoc.han.tracnghiemapp.interfaces.IMesseageHandler;
import app.ngoc.han.tracnghiemapp.interfaces.INavigationController;
import butterknife.ButterKnife;

/**
 * Created by hai.tran on 11/8/2016.
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected INavigationController mNavigationController;
    protected IMesseageHandler mMesseageHandler;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mActivity = (BaseActivity) context;
            mNavigationController = mActivity;
            mMesseageHandler = mActivity;
        } catch (Exception e) {
            Log.e("Error", "Fragment must be add inside BaseActivity");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
