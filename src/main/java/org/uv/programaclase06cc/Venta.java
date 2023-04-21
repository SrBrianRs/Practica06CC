/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programaclase06cc;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author SrBri
 */
    @Entity
    @Table(name = "venta")
public class Venta {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name = "monto")
    private float monto ;
    //cambiar a decimal
    @Column(name = "fecha")
    private String fecha;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "venta")
    private Set<VentaDetalle> VentaDetalle;

    public Venta(float monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public Venta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    
    
    
}
