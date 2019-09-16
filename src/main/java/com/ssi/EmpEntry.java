package com.ssi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EmpEntry {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();

		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(sr);
		Session session = sf.openSession();
		Emp e1 = new Emp(111, "AAA", 50000);
		Emp e2 = new Emp(112, "BBB", 60000);
		Emp e3 = new Emp(113, "CCC", 70000);
		Emp e4 = new Emp(114, "DDD", 80000);
		Emp e5 = new Emp(115, "EEE", 90000);
		Emp e6 = new Emp(117, "Anjali", 56000);
		e6.setEno(116);

		// Insert data using hibernate
		Transaction tr = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.save(e6);

		System.out.println("RECORD ADDED");

		// Delete data using hibernate
		session.delete(e1);
		System.out.println("RECORD DELETED");

		// Update data using hibernate
		session.update(e6);
		tr.commit();
		session.close();
		System.out.println("RECORD UPDATED");
	}

}
