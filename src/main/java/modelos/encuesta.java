/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author JosselynMartinez
 */
public class encuesta {
    private int id;
    private String nombre;
    private String sexo;
    private String deporte;
    private String estudio;
    private String tema;
    private int cantidad;
    private String tipo;
    
    public encuesta() {}
    
    public encuesta(String nombre, String sexo, String deporte, String estudio, String tema ) {
        this .nombre = nombre;
        this .sexo =sexo;
        this .deporte =deporte;
        this .estudio =estudio;
        this .tema =tema;
    }
    
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSexo(String sexo) {this .sexo = sexo;}
    public void setDeporte(String deporte) { this.deporte = deporte; }
    public void setEstudio (String estudio) {this .estudio = estudio;}
    public void setTema(String tema) { this.tema = tema; }
    public void setCantidad (int cantidad) {this .cantidad = cantidad;}
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getSexo() { return sexo; }
    public String getDeporte() { return deporte; }
    public String getEstudio() { return estudio; }
    public String getTema() { return tema; }
    public int getCantidad() { return cantidad; }
    public String getTipo() { return tipo; }
}
