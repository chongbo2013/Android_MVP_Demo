package com.jiechic.mvp.presenters;


import com.jiechic.mvp.views.ISimpleDialogView;

public class SimpleDialogPresenter {
    private ISimpleDialogView dialogView;

    public SimpleDialogPresenter(ISimpleDialogView dialogView) {
        this.dialogView = dialogView;
    }

    public void show() {
        dialogView.show();
    }
}
