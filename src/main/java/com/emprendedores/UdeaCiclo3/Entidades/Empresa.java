package com.emprendedores.UdeaCiclo3.Entidades;

// Librerias
import javax.persistence.*;


@Entity // Crear Entidad Empresa
@Table(name="Empresa")
public class Empresa { //Inicio clase Empresa
    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) // Genera Id Automaticamente
    // Atributos
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    //Constructores

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    // Getters and Setters


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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

} // Finaliza clase Empresa
