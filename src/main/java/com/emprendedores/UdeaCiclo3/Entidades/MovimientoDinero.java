package com.emprendedores.UdeaCiclo3.Entidades;

//Librerias

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity // Crear Entidad Movimientos
@Table(name="Movimientos")
public class MovimientoDinero { //Inicio clase MovimientoDinero
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera Id Automaticamente)
    // Atributos
    private int id;
    private long monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleado_id")// Crea relacion de muchos a uno
    private Empleado usuario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    // Constructores
    public MovimientoDinero() {
    }

    public MovimientoDinero(long monto, String concepto, Empleado usuario, Date fecha) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
} // Finaliza clase MovimientoDinero
