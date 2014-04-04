/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.dao.implement;

import com.jatismobile.workshop.dao.service.ProjectDao;
import com.jatismobile.workshop.model.Project;
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
public class ProjectDaoImpl implements ProjectDao{

    @Autowired SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public void save(Project project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    @Override
    @Transactional
    public void delete(Project project) {
        sessionFactory.getCurrentSession().delete(project);
    }

    @Override
    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Project").list();
    }

    @Override
    public Project findById(int id) {
        return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
    }
}
