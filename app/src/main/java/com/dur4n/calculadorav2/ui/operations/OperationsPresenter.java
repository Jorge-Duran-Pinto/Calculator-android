package com.dur4n.calculadorav2.ui.operations;

import android.util.Log;
import android.view.View;

import com.dur4n.calculadorav2.data.repository.OperationsRepository;

public class OperationsPresenter implements OperationsContract.Presenter {

    OperationsContract.View view;
    OperationsInteractor interactor;

    public OperationsPresenter(OperationsContract.View view) {
        this.view = view;
        this.interactor = new OperationsInteractor(this);
    }


    public void doOperation(String message) {
        interactor.doOperation(message);
    }

    @Override
    public void onInsertSuccess(String message) {
        view.onInsertSuccess(message);
    }

    @Override
    public void onOperationSuccess(String message) {
        view.onOperationSuccess(message);
    }

    @Override
    public void onFailure(String message) {
        view.onFailure(message);
    }

    @Override
    public void onDestroy() {
        this.interactor = null;
        this.view = null;
    }
}
