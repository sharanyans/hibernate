package com.tut.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tut.dto.Customer;
public class Add {
	public static void main(String[] args) {
		Customer c= new Customer();
		
		c.setName("Sandy");
		c.setAccount("etert44");
		c.setBalance(200.00);
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager manager=factory.createEntityManager();
		manager.persist(c);
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println(c.getId());
		
	}

}
