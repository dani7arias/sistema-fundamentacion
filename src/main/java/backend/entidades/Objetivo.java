package backend.entidades;

public class Objetivo {

    private Integer idObjetivos;

    private String objetivo;

    public Objetivo() {

    }

    public Objetivo(Integer idObjetivos, String objetivo) {
        this.idObjetivos = idObjetivos;
        this.objetivo = objetivo;
    }

    public Integer getIdObjetivos() {
        return idObjetivos;
    }

    public void setIdObjetivos(Integer idObjetivos) {
        this.idObjetivos = idObjetivos;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "Objetivo{" + "idObjetivos=" + idObjetivos + ", objetivo=" + objetivo + '}';
    }

}
