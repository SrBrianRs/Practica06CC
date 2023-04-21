/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programaclase06cc;

import org.hibernate.Session;

/**
 *
 * @author SrBri
 */
public class ProgramaClase06cc {

    public static void main(String[] args) {
        DAOVenta daoV=new DAOVenta();
        DAOVentaDetalle daoD=new DAOVentaDetalle();
        
        Venta ven=new Venta(3,"16/04/23");
        ven=daoV.create(ven);
                
        VentaDetalle v1=new VentaDetalle();
        VentaDetalle v2=new VentaDetalle();
        
        v1.setDescripcion("Chetos");
        v1.setPrecio(8.00f);
        v1.setCantidad(30);
        v1.setSubtotal(v1.getPrecio()*v1.getCantidad());
        v1.setVenta(ven);
        
        
        v2.setDescripcion("Takis Azules");
        v2.setPrecio(18.00f);
        v2.setCantidad(20);
        v2.setSubtotal(v2.getPrecio()*v2.getCantidad());
        v2.setVenta(ven);
        
        daoD.create(v1);
        daoD.create(v2);


    }
}
