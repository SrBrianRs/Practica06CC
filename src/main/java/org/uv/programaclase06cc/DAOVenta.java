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
public class DAOVenta implements IDAOGeneral<Venta, Integer>{

    @Override
    public Venta create(Venta p) {

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
        
        Venta v = new Venta();
        v.setId(id);
        session.delete(v);
        
        t.commit();
        session.close();
        return true;

    }

    @Override
    public Venta update(Integer id, Venta p) {

        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        Venta v=findById(id);
        if(v!=null && p.getId()==id) {
            session.update(p);
        }
        t.commit();
        session.close();
        return v;

    }

    @Override
    public List<Venta> findAll() {

       Session session = HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        List <Venta>lstv;
        lstv= session.createQuery("from Venta").list();

        transaction.commit();
        session.close();
        return lstv;
        

    }

    @Override
    public Venta findById(Integer id) {

        Session session = HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Venta venta = (Venta)session.get(Venta.class, id);
        
        if(venta!=null){
            transaction.commit();
            session.close();
            return venta;
        }
        else{
            return null;
        }

    }
    
}
