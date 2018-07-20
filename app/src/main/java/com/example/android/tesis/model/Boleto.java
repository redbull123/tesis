package com.example.android.tesis.model;

/**
 * Created by rjsan on 7/20/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Boleto {

    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("itinerarioId")
    @Expose
    private ItinerarioId itinerarioId;
    @SerializedName("tipoBoletoId")
    @Expose
    private TipoBoletoId tipoBoletoId;
    @SerializedName("usuarioId")
    @Expose
    private UsuarioId usuarioId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Boleto() {
    }

    /**
     *
     * @param id
     * @param hora
     * @param fecha
     * @param tipoBoletoId
     * @param usuarioId
     * @param itinerarioId
     */
    public Boleto(String fecha, String hora, int id, ItinerarioId itinerarioId, TipoBoletoId tipoBoletoId, UsuarioId usuarioId) {
        super();
        this.fecha = fecha;
        this.hora = hora;
        this.id = id;
        this.itinerarioId = itinerarioId;
        this.tipoBoletoId = tipoBoletoId;
        this.usuarioId = usuarioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItinerarioId getItinerarioId() {
        return itinerarioId;
    }

    public void setItinerarioId(ItinerarioId itinerarioId) {
        this.itinerarioId = itinerarioId;
    }

    public TipoBoletoId getTipoBoletoId() {
        return tipoBoletoId;
    }

    public void setTipoBoletoId(TipoBoletoId tipoBoletoId) {
        this.tipoBoletoId = tipoBoletoId;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioId usuarioId) {
        this.usuarioId = usuarioId;
    }

}