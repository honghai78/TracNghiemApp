package app.ngoc.han.tracnghiemapp.views;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import app.ngoc.han.tracnghiemapp.R;
import app.ngoc.han.tracnghiemapp.interfaces.IMesseageHandler;
import app.ngoc.han.tracnghiemapp.interfaces.INavigationController;
import butterknife.ButterKnife;


/**
 * Created by hai.tran on 11/8/2016.
 */
public class BaseActivity extends AppCompatActivity implements INavigationController, IMesseageHandler {
    private ProgressDialog progressDialog;

    @Override
    public void showDialogMessage(String title, String mess, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this).setTitle(title)
                .setMessage(mess)
                .setNegativeButton("OKAY", listener != null ? listener : new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public void showLoadingDialogLayout(String mess) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(R.style.MaterialDialog);
        progressDialog.setMessage(mess);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    @Override
    public void hideMessage() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void openActivity(Context packerContext, Class<?> activityToOpen) {
        Intent intent = new Intent(packerContext, activityToOpen);
        startActivity(intent);
        finish();
    }


    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openNewFragment(int resId, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_up,
                R.anim.slide_out_down);
        ft.add(resId, fragment).commit();
    }

    @Override
    public void replaceFragment(int resId, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(fragment.getClass().getName());
        ft.setCustomAnimations(R.anim.slide_in_up,
                R.anim.slide_out_down);
        ft.replace(resId, fragment).commit();
    }

    @Override
    public void clearAllBackStack() {
        while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

}
