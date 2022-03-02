package com.dur4n.calculadorav2.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Operacion implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    String operacion;

    public Operacion(int id, @NonNull String operacion) {
        this.id = id;
        this.operacion = operacion;
    }

    @Ignore
    public Operacion(@NonNull String operacion) {
        this.operacion = operacion;
    }


    @Ignore
    protected Operacion(Parcel in) {
        id = in.readInt();
        operacion = in.readString();
    }

    public static final Creator<Operacion> CREATOR = new Creator<Operacion>() {
        @Override
        public Operacion createFromParcel(Parcel in) {
            return new Operacion(in);
        }

        @Override
        public Operacion[] newArray(int size) {
            return new Operacion[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(@NonNull String operacion) {
        this.operacion = operacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(operacion);
    }
}
