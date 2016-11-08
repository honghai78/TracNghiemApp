package app.ngoc.han.tracnghiemapp.adapters.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.ngoc.han.tracnghiemapp.R;
import app.ngoc.han.tracnghiemapp.interfaces.ItemListener;
import app.ngoc.han.tracnghiemapp.models.TitleTest;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hai.tran on 11/8/2016.
 */

public class TitleTestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    @BindView(R.id.tense)
    TextView tense;
    @BindView(R.id.image)
    CircleImageView image;
    @BindView(R.id.btnLT)
    Button btnLT;
    private Context mContext;
    private ItemListener mListener;

    public TitleTestViewHolder(Context context, View itemView, ItemListener listener) {
        super(itemView);
        mContext = context;
        mListener = listener;
        ButterKnife.bind(this, itemView);
        itemView.setOnLongClickListener(this);
    }

    public void setData(TitleTest titleTest) {
        tense.setText(titleTest.getName());
        btnLT.setOnClickListener(this);
        int id = mContext.getResources().getIdentifier(titleTest.getImageLink(), "drawable", mContext.getPackageName());
        image.setImageResource(id);
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onItemClicked(btnLT, getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mListener != null) {
            mListener.onItemLongClicked(itemView, getAdapterPosition());
        }
        return false;
    }
}
