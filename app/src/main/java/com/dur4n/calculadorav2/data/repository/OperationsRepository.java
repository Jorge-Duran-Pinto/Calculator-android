package com.dur4n.calculadorav2.data.repository;

import com.dur4n.calculadorav2.data.LocalDB;
import com.dur4n.calculadorav2.data.dao.OperationDAO;
import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.ui.operations.OperationsContract;
import com.dur4n.calculadorav2.ui.operationsList.OperationsListContract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class OperationsRepository implements OperationsContract.Repository, OperationsListContract.Repository {

    static OperationsRepository repository;
    static OperationDAO operationDAO;

    public OperationsRepository() {
        this.operationDAO = LocalDB.getDatabase().operationDAO();
    }

    public static OperationsRepository getInstance(){
        if (repository == null)
            repository = new OperationsRepository();
        return repository;
    }

    @Override
    public void insertOperation(Operacion operacion, OperationsContract.InteractorListener listener) {
        Long result = null;

        try {
            result = LocalDB.databaseWriteExecutor.submit(()->operationDAO.insert(operacion)).get();
        } catch (ExecutionException e) {
            listener.onFailure("Error in the database");
        } catch (InterruptedException e) {
            listener.onFailure("Error in the database");
        }
        if (result == 0)
            listener.onFailure("Error in the database");
        else
            listener.onInsertSuccess("Operation saved");
    }

    @Override
    public void getOperations(OperationsListContract.InteractorListener listener) {
        List<Operacion> operacionList = null;
        try {
            operacionList = LocalDB.databaseWriteExecutor.submit(()->operationDAO.getOperations()).get();
        } catch (ExecutionException e) {
            listener.onFailure(e.toString());
            return;
        } catch (InterruptedException e) {
            listener.onFailure(e.toString());
            return;
        }
        if(operacionList.size() == 0)
            listener.onFailure("Empty");
        else
            listener.onListSuccess(operacionList);
    }
}
