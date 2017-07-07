/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portfoliovaleria.model.connection;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author valerialarissa
 */
public class ConnectionTest {
  private final EntityManager entityManager;

    public ConnectionTest() {
        entityManager = DBConnection.newInstance().getEntityManager();
    }

    @Test
    public void hasValidConnection() {
        Assert.assertNotNull(entityManager);
        Assert.assertTrue(entityManager.isOpen());
    }
}   

