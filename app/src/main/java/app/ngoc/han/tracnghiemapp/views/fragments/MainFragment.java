package app.ngoc.han.tracnghiemapp.views.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.ngoc.han.tracnghiemapp.R;
import app.ngoc.han.tracnghiemapp.Utils.Util;
import app.ngoc.han.tracnghiemapp.adapters.TitleTestAdapter;
import app.ngoc.han.tracnghiemapp.interfaces.ItemListener;
import app.ngoc.han.tracnghiemapp.models.TitleTest;
import app.ngoc.han.tracnghiemapp.views.BaseFragment;
import app.ngoc.han.tracnghiemapp.views.activitys.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hai.tran on 11/8/2016.
 */

public class MainFragment extends BaseFragment implements ItemListener {

    private static int RECYCLER_VIEW_COLUMN = 2;
    @BindView(R.id.textTime)
    TextView textTime;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private List<TitleTest> mList;
    private TitleTestAdapter mAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(android.content.Context context) {
        return (MainFragment) Fragment.instantiate(context, MainFragment.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList = TitleTest.arrayTitleTestFromData(Util.parseJsonFromRaw(getContext(), R.raw.title_test), "titles");
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), RECYCLER_VIEW_COLUMN));
        mAdapter = new TitleTestAdapter(getActivity(), mList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onItemLongClicked(View view, int position) {
        return false;
    }

    @Override
    public void onItemClicked(View view, int position) {
        mMesseageHandler.showDialogMessage(mList.get(position).getName(), "click on item " + (mList.get(position).getName()), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
