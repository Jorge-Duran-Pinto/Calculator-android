package com.dur4n.calculadorav2.ui.operations;

import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.data.repository.OperationsRepository;
import com.dur4n.calculadorav2.ui.utils.Calculator;

public class OperationsInteractor implements OperationsContract.InteractorListener {

    OperationsContract.InteractorListener listener;

    public OperationsInteractor(OperationsContract.InteractorListener listener) {
        this.listener = listener;
    }


    public void doOperation(String message) {
        Calculator.getInstance().doOperation(message, this);
    }

    @Override
    public void onInsertSuccess(String message) {
        listener.onInsertSuccess(message);
    }
    @Override
    public void onOperationSuccess(String message) {
        listener.onOperationSuccess(message);

        Operacion operacion = new Operacion(message);
        OperationsRepository.getInstance().insertOperation(operacion, listener);
    }
    @Override
    public void onFailure(String message) {
        listener.onFailure(message);
    }


}
