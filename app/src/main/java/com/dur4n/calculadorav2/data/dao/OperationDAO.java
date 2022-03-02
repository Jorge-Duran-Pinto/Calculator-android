package com.dur4n.calculadorav2.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dur4n.calculadorav2.data.model.Operacion;

import java.util.List;

@Dao
public interface OperationDAO {
    @Insert
    long insert(Operacion operacion);

    @Query("SELECT * FROM operacion")
    List<Operacion> getOperations();
}
