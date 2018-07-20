package com.example.android.tesis.model;

/**
 * Created by rjsan on 7/20/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Itinerario {

    @SerializedName("barcoId")
    @Expose
    private Barco barcoId;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("rutaId")
    @Expose
    private Ruta rutaId;
    @SerializedName("time")
    @Expose
    private String time;

    /**
     * No args constructor for use in serialization
     *
     */
    public Itinerario() {
    }

    /**
     *
     * @param id
     * @param time
     * @param barcoId
     * @param fecha
     * @param rutaId
     */
    public Itinerario(BarcoId barcoId, String fecha, int id, RutaId rutaId, String time) {
        super();
        this.barcoId = barcoId;
        this.fecha = fecha;
        this.id = id;
        this.rutaId = rutaId;
        this.time = time;
    }

    public BarcoId getBarcoId() {
        return barcoId;
    }

    public void setBarcoId(BarcoId barcoId) {
        this.barcoId = barcoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RutaId getRutaId() {
        return rutaId;
    }

    public void setRutaId(RutaId rutaId) {
        this.rutaId = rutaId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}