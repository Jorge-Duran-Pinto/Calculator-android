package com.dur4n.calculadorav2.ui.operationsList;

import com.dur4n.calculadorav2.data.model.Operacion;

import java.util.List;

public class OperationListPresenter implements OperationsListContract.Presenter{

    OperationListInteractor interactor;
    OperationsListContract.View view;

    public OperationListPresenter(OperationsListContract.View view) {
        this.view = view;
        this.interactor = new OperationListInteractor(this);
    }

    @Override
    public void getOperations() {
        interactor.getOperations(this);
    }

    @Override
    public void onListSuccess(List<Operacion> operacionList) {
        view.onListSuccess(operacionList);
    }

    @Override
    public void onFailure(String message) {
        view.onFailure(message);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }
}
