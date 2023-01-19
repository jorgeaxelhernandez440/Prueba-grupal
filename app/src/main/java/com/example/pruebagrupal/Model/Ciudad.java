package com.example.pruebagrupal.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ciudad implements Parcelable {
    private Integer ciudad_id;
    private String ciudad;
    private Integer estado_id;

    public Ciudad(Integer estado_id, String nombreMunicipio, Integer fkEstado) {
        this.ciudad_id = estado_id;
        this.ciudad = nombreMunicipio;
        this.estado_id = fkEstado;
    }

    protected Ciudad(Parcel in) {
        if (in.readByte() == 0) {
            ciudad_id = null;
        } else {
            ciudad_id = in.readInt();
        }
        ciudad = in.readString();
        if (in.readByte() == 0) {
            estado_id = null;
        } else {
            estado_id = in.readInt();
        }
    }

    public static final Creator<Ciudad> CREATOR = new Creator<Ciudad>() {
        @Override
        public Ciudad createFromParcel(Parcel in) {
            return new Ciudad(in);
        }

        @Override
        public Ciudad[] newArray(int size) {
            return new Ciudad[size];
        }
    };

    public Integer getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(Integer ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getPais_id() {
        return estado_id;
    }

    public void setPais_id(Integer pais_id) {
        this.estado_id = pais_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (ciudad_id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ciudad_id);
        }
        parcel.writeString(ciudad);
        if (estado_id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(estado_id);
        }
    }
}
