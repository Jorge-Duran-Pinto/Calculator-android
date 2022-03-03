package com.dur4n.calculadorav2.ui.operationsList;

import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.data.repository.OperationsRepository;

import java.util.List;

public class OperationListInteractor implements OperationsListContract.InteractorListener{

    OperationsListContract.InteractorListener listener;

    public OperationListInteractor(OperationsListContract.InteractorListener listener) {
        this.listener = listener;
    }

    public void getOperations(OperationsListContract.InteractorListener listener) {
        OperationsRepository.getInstance().getOperations(this);
    }

    @Override
    public void onListSuccess(List<Operacion> operacionList) {
        listener.onListSuccess(operacionList);
    }
    @Override
    public void onFailure(String message) {
        listener.onFailure(message);
    }
}
