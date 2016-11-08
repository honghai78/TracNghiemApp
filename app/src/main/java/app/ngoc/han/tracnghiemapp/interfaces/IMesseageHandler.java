package app.ngoc.han.tracnghiemapp.interfaces;

import android.content.DialogInterface;

public interface IMesseageHandler {
    void showLoadingDialogLayout(String mess);

    void hideMessage();

    void showToast(String text);

    void showDialogMessage(String title, String mess, DialogInterface.OnClickListener onClickListener);
}
