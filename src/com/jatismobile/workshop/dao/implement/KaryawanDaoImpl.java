/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.implement;

import com.jatismobile.workshop.dao.service.KaryawanDao;
import com.jatismobile.workshop.model.Karyawan;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lukman
 */
@Component
@Transactional(readOnly = true)
public class KaryawanDaoImpl implements KaryawanDao{

    @Autowired private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public void save(Karyawan karyawan) {
        sessionFactory.getCurrentSession().saveOrUpdate(karyawan);
    }

    @Override
    @Transactional
    public void delete(Karyawan karyawan) {
        sessionFactory.getCurrentSession().delete(karyawan);
    }

    @Override
    public List<Karyawan> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Karyawan").list();
    }

    @Override
    public Karyawan findById(int id) {
        return (Karyawan) sessionFactory.getCurrentSession().get(Karyawan.class, id);
    }

    @Override
    public List<Karyawan> findByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("from Karyawan where namaKaryawan=:name")
                .setParameter("name", name).list();
    }
    
}
