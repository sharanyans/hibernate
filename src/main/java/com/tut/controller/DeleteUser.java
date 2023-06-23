
package com.tut.controller;
import javax.persistence.*;

import com.tut.dto.Customer;

import java.util.List;

public class DeleteUser {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            
            List<Customer> customersToDelete = entityManager.createQuery("SELECT c FROM Customer c WHERE c.balance < :balance", Customer.class)
                .setParameter("balance", 100.0)
                .getResultList();

            for (Customer customer : customersToDelete) {
                entityManager.remove(customer);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
