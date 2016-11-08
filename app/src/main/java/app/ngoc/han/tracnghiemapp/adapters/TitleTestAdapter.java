package app.ngoc.han.tracnghiemapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import app.ngoc.han.tracnghiemapp.R;
import app.ngoc.han.tracnghiemapp.adapters.viewholder.TitleTestViewHolder;
import app.ngoc.han.tracnghiemapp.interfaces.ItemListener;
import app.ngoc.han.tracnghiemapp.models.TitleTest;

/**
 * Created by hai.tran on 11/8/2016.
 */

public class TitleTestAdapter extends RecyclerView.Adapter<TitleTestViewHolder> {
    private List<TitleTest> mList;
    private Context mContext;
    private ItemListener clickListener;

    public TitleTestAdapter(Context context, List<TitleTest> list, ItemListener clickListener) {
        this.mList = list;
        this.mContext = context;
        this.clickListener = clickListener;
    }

    @Override
    public TitleTestViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_test_item, parent, false);
        TitleTestViewHolder viewHolder = new TitleTestViewHolder(mContext, view, clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TitleTestViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
