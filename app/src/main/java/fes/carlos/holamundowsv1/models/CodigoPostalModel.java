package fes.carlos.holamundowsv1.models;

public class CodigoPostalModel {
    private String codigoPostal;
    private int alcaldiaId;
    private String alcaldia;
    private String estado;
    private int estadoId;
    private String tipoDeAsentamiento;
    private String asentamiento;



    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getAlcaldiaId() {
        return alcaldiaId;
    }

    public void setAlcaldiaId(int alcaldiaId) {
        this.alcaldiaId = alcaldiaId;
    }

    public String getAlcaldia() {
        return alcaldia;
    }

    public void setAlcaldia(String alcaldia) {
        this.alcaldia = alcaldia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getTipoDeAsentamiento() {
        return tipoDeAsentamiento;
    }

    public void setTipoDeAsentamiento(String tipoDeAsentamiento) {
        this.tipoDeAsentamiento = tipoDeAsentamiento;
    }

    public String getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }
}
