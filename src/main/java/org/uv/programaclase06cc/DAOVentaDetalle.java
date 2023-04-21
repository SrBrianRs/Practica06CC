/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programaclase06cc;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SrBri
 */
public class DAOVentaDetalle implements IDAOGeneral<VentaDetalle, Integer>{


    @Override
    public VentaDetalle create(VentaDetalle p) {
        Session session=HibernateUtil.getSession();
        Transaction t=session .beginTransaction();
        
        session.save(p);
        
        t.commit();
        session.close();
        return p;
    }

    @Override
    public boolean delete(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session .beginTransaction();
        
        VentaDetalle vd = new VentaDetalle();
        vd.setId_producto(id);
        session.delete(vd);
        
        t.commit();
        session.close();
        return true;
    }

    @Override
    public VentaDetalle update(Integer id, VentaDetalle p) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        VentaDetalle vd=findById(id);
        if(vd!=null && p.getId_producto()==id) {
            session.update(p);
        }
        t.commit();
        session.close();
        return vd;
    }

    @Override
    public List<VentaDetalle> findAll() {
        Session session = HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        List <VentaDetalle>lstvd;
        lstvd= session.createQuery("from Venta detalles").list();

        transaction.commit();
        session.close();
        return lstvd;
        
       
    }

    @Override
    public VentaDetalle findById(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        VentaDetalle ventad = (VentaDetalle)session.get(VentaDetalle.class, id);
        
        if(ventad!=null){
            transaction.commit();
            session.close();
            return ventad;
        }
        else{
            return null;
        }
    }
    
}
