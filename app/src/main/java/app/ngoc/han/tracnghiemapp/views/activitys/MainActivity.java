package app.ngoc.han.tracnghiemapp.views.activitys;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import app.ngoc.han.tracnghiemapp.R;
import app.ngoc.han.tracnghiemapp.views.BaseActivity;
import app.ngoc.han.tracnghiemapp.views.fragments.MainFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import app.ngoc.han.tracnghiemapp.Utils.Util;

public class MainActivity extends BaseActivity {
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer)
    View mDrawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        setupDrawerView();
        openNewFragment(R.id.fragment_container, MainFragment.newInstance(getBaseContext()));
    }

    public void setupDrawerView() {
        mDrawerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        int displayViewWidth_ = Util.getScreenSize(this).getWight();
        final ViewGroup.LayoutParams params = mDrawerView.getLayoutParams();
        params.width = displayViewWidth_ * 5 / 6;
        mDrawerView.setLayoutParams(params);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.app_name,
                R.string.app_name
        );
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    public void setDrawerToggleButtonAction(boolean b) {
        mDrawerToggle.setDrawerIndicatorEnabled(b);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
