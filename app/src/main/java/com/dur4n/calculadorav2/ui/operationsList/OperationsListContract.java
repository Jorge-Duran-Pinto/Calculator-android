package com.dur4n.calculadorav2.ui.operationsList;

import com.dur4n.calculadorav2.ui.base.IBasePresenter;
import com.dur4n.calculadorav2.ui.base.operaciones.OnOperationRepositoryList;

public interface OperationsListContract {
    interface View extends InteractorListener{
        void getOperations();
    }
    interface Presenter extends IBasePresenter, InteractorListener {
        void getOperations();
    }
    interface InteractorListener extends Callback{

    }
    interface Callback extends OnOperationRepositoryList {
        void onFailure(String message);
    }
    interface Repository{
        void getOperations(InteractorListener listener);
    }
}
