package com.dur4n.calculadorav2.ui.base.operaciones;

import com.dur4n.calculadorav2.data.model.Operacion;

import java.util.List;

public interface OnOperationRepositoryList {
    void onListSuccess(List<Operacion> operacionList);
}
