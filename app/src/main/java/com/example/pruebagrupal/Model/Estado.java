package com.example.pruebagrupal.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Estado implements Parcelable {
    private Integer estado_id;
    private String estado;
    private Integer pais_id;


    public Estado(Integer estado_id, String estado,Integer pais_id) {
        this.estado_id = estado_id;
        this.estado = estado;
        this.pais_id = pais_id;

    }

    protected Estado(Parcel in) {
        if (in.readByte() == 0) {
            estado_id = null;
        } else {
            estado_id = in.readInt();
        }
        estado = in.readString();
        if (in.readByte() == 0){
            pais_id = null;
        }else {
            pais_id = in.readInt();
        }
    }

    public static final Creator<Estado> CREATOR = new Creator<Estado>() {
        @Override
        public Estado createFromParcel(Parcel in) {
            return new Estado(in);
        }

        @Override
        public Estado[] newArray(int size) {
            return new Estado[size];
        }
    };

    public Integer getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Integer estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPais_id() {
        return pais_id;
    }

    public void setPais_id(Integer pais_id) {
        this.pais_id = pais_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (estado_id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(estado_id);
        }
        parcel.writeString(estado);
        if (pais_id == null){
            parcel.writeByte((byte) 0);
        }else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(pais_id);
        }
    }
}
