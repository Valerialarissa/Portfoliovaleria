/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portfoliovaleria.model.dao;

/**
 *
 * @author valerialarissa
 */
/* @param <T> entidade a ser persistida no banco de dados
 */

import br.com.portfoliovaleria.model.connection.DBConnection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AbstractDAO<T> implements Serializable {

    private final Class<T> clazz;

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            getEntityManager().close();
        }
    }

    public List<T> listAll() {
        String hql = "select obj from " + clazz.getSimpleName() + " obj order by obj.id";
        Query query = getEntityManager().createQuery(hql);
        return query.getResultList();
    }

    protected EntityManager getEntityManager() {
        return DBConnection.newInstance().getEntityManager();
    }

}
