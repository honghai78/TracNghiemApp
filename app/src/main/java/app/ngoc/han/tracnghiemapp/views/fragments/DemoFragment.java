package app.ngoc.han.tracnghiemapp.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.ngoc.han.tracnghiemapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {


    public DemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

}
