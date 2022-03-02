package com.dur4n.calculadorav2.data.repository;

import com.dur4n.calculadorav2.data.LocalDB;
import com.dur4n.calculadorav2.data.dao.OperationDAO;
import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.ui.operations.OperationsContract;

import java.util.concurrent.ExecutionException;

public class OperationsRepository implements OperationsContract.Repository {

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
}
