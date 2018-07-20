package com.example.android.tesis.model;

/**
 * Created by rjsan on 7/20/2018.
 */import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("ci")
    @Expose
    private int ci;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("perfil")
    @Expose
    private String perfil;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("usuario")
    @Expose
    private String usuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param nombre
     * @param id
     * @param apellido
     * @param usuario
     * @param status
     * @param perfil
     * @param ci
     * @param password
     */
    public Usuario(String apellido, int ci, int id, String nombre, String password, String perfil, int status, String usuario) {
        super();
        this.apellido = apellido;
        this.ci = ci;
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.perfil = perfil;
        this.status = status;
        this.usuario = usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}