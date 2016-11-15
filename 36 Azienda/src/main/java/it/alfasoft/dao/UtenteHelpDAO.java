package it.alfasoft.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import it.alfasoft.bean.UtenteHelp;
import it.alfasoft.utils.HibernateUtil;

public class UtenteHelpDAO {

	public boolean aggiungiHelp(UtenteHelp u) {

		checkQuantity();
		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		boolean result = false;

		try {

			tx = session.getTransaction();
			tx.begin();
			session.persist(u);
			tx.commit();
			result = true;

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}

	// Memorizzo al massimo 50 richieste di aiuto
	private void checkQuantity (){
	
		Session session = HibernateUtil.openSession();
		Number res = (Number) session.createCriteria(UtenteHelp.class).setProjection(Projections.rowCount()).uniqueResult();

		
		System.out.println(res.intValue());
		if (res.intValue() == 50){
		
		}
		Number minimum = (Number) session.createCriteria(UtenteHelp.class).setProjection(Projections.min("id")).uniqueResult();
		System.out.println(minimum.intValue());
	}
}