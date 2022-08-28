package com.emprendedores.UdeaCiclo3.Entidades;

// Libreria
import javax.persistence.*;

@Entity // Crear Entidad Empleado
@Table(name="Empleado")
public class Empleado {//Inicio clase Empleado

    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) // Genera Id Automaticamente

    @OneToMany // Crea relacion de uno a muchos con MovimientoDinero
    @JoinColumn(name = "movimientosDinero_usuario")

    // Atributos
    private int id;
    private String nombre;
    private String email;
    @ManyToOne // Crea relacion de muchos a uno
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    private String rol;

    // Constructores
    public Empleado() {
    }

    public Empleado(String nombre, String email, Empresa empresa, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.empresa = empresa;
        this.rol = rol;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
} // Fin clase Empleado
