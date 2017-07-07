/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portfoliovaleria.model.connection;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author valerialarissa
 */
public class DBConnection implements Serializable {
        private static final String PU = "portfoliovaleriaPU";
    private static DBConnection instance;
    private final EntityManagerFactory factory;
    private EntityManager entityManager;

    private DBConnection() {
        factory = Persistence.createEntityManagerFactory(PU);
    }

    public static synchronized DBConnection newInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
