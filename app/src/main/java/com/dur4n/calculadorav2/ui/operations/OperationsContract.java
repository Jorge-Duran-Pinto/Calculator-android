package com.dur4n.calculadorav2.ui.operations;

import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.ui.base.IBasePresenter;
import com.dur4n.calculadorav2.ui.base.operaciones.OnOperationRepositoryInsert;
import com.dur4n.calculadorav2.ui.base.operaciones.OnOperationResult;

public interface OperationsContract {
    interface View extends InteractorListener{
        void showOnOperationSuccess(String message);
        void showOnOperationInsertSuccess(String message);
        void showOnFailure(String message);
    }
    interface Presenter extends InteractorListener, IBasePresenter {

    }
    interface InteractorListener extends Callback{

    }
    interface Repository {
        void insertOperation(Operacion operacion, InteractorListener listener);
    }
    interface Callback extends OnOperationRepositoryInsert, OnOperationResult {
        void onFailure(String message);
    }

}
