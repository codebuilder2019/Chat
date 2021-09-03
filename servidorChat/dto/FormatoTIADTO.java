package servidorChat.dto;

import java.io.Serializable;

public class FormatoTIADTO implements Serializable 
{
    private int id;
    private String nombrePrograma;
    private String titulo;
    private String nombreEstudiante1;
    private int codigoEstudiante1;
    private String nombreEstudiante2;
    private int codigoEstudiante2;
    private String nombreDirector;
    private int codigoDirector;
    private String codirector;
    private String objetivos;
    private int codigoEvaluador1;
    private int codigoEvaluador2;

    public FormatoTIADTO(int id, String nombrePrograma, String titulo, String nombreEstudiante1, int codigoEstudiante1, String nombreEstudiante2, int codigoEstudiante2, String nombreDirector, int codigoDirector, String codirector, String objetivos, int codigoEvaluador1, int codigoEvaluador2) {
        this.id = id;
        this.nombrePrograma = nombrePrograma;
        this.titulo = titulo;
        this.nombreEstudiante1 = nombreEstudiante1;
        this.codigoEstudiante1 = codigoEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
        this.codigoEstudiante2 = codigoEstudiante2;
        this.nombreDirector = nombreDirector;
        this.codigoDirector = codigoDirector;
        this.codirector = codirector;
        this.objetivos = objetivos;
        this.codigoEvaluador1 = codigoEvaluador1;
        this.codigoEvaluador2 = codigoEvaluador2;
    }

    public int getId() {
        return id;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreEstudiante1() {
        return nombreEstudiante1;
    }

    public int getCodigoEstudiante1() {
        return codigoEstudiante1;
    }

    public String getNombreEstudiante2() {
        return nombreEstudiante2;
    }

    public int getCodigoEstudiante2() {
        return codigoEstudiante2;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public int getCodigoDirector() {
        return codigoDirector;
    }

    public String getCodirector() {
        return codirector;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public int getCodigoEvaluador1() {
        return codigoEvaluador1;
    }

    public int getCodigoEvaluador2() {
        return codigoEvaluador2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombreEstudiante1(String nombreEstudiante1) {
        this.nombreEstudiante1 = nombreEstudiante1;
    }

    public void setCodigoEstudiante1(int codigoEstudiante1) {
        this.codigoEstudiante1 = codigoEstudiante1;
    }

    public void setNombreEstudiante2(String nombreEstudiante2) {
        this.nombreEstudiante2 = nombreEstudiante2;
    }

    public void setCodigoEstudiante2(int codigoEstudiante2) {
        this.codigoEstudiante2 = codigoEstudiante2;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public void setCodigoDirector(int codigoDirector) {
        this.codigoDirector = codigoDirector;
    }

    public void setCodirector(String codirector) {
        this.codirector = codirector;
    }
    
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public void setCodigoEvaluador1(int codigoEvaluador1) {
        this.codigoEvaluador1 = codigoEvaluador1;
    }

    public void setCodigoEvaluador2(int codigoEvaluador2) {
        this.codigoEvaluador2 = codigoEvaluador2;
    }
}