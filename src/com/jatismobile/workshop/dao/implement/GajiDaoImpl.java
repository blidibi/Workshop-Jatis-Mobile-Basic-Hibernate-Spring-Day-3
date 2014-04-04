/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.implement;

import com.jatismobile.workshop.dao.service.GajiDao;
import com.jatismobile.workshop.model.Gaji;
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
public class GajiDaoImpl implements GajiDao{

    @Autowired private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public void save(Gaji gaji) {
        sessionFactory.getCurrentSession().saveOrUpdate(gaji);
    }

    @Override
    @Transactional
    public void delete(Gaji gaji) {
        sessionFactory.getCurrentSession().delete(gaji);
    }

    @Override
    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Gaji").list();
    }

    @Override
    public Gaji findById(int id) {
        return (Gaji) sessionFactory.getCurrentSession().get(Gaji.class, id);
    }
    
}
