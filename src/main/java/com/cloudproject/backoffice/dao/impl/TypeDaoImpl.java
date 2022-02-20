package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.TypeDao;
import com.cloudproject.backoffice.model.Region;
import com.cloudproject.backoffice.model.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.HibernateException;

@Repository("TypeDao")
public class TypeDaoImpl implements TypeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Type> getType() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(Type.class).list();
            tx.commit();
            return type;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
