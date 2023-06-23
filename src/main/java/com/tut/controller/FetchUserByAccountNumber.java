package com.tut.controller;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

import com.tut.dto.Customer;

public class FetchUserByAccountNumber {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the account number to find the customer");
		String account=s.next();

		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager manager=factory.createEntityManager();
		javax.persistence.Query q = manager.createNamedQuery("fecthByAccount");
		q.setParameter(1, account);
		
		List<Customer> customers=q.getResultList();
		for(Customer c:customers) {
			System.out.println(c);
		}
		
	}

}
