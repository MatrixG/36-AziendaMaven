package it.alfasoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import it.alfasoft.bean.UtenteHelp;
import it.alfasoft.utils.HibernateUtil;

public class UtenteHelpDAO {

	public boolean aggiungiHelp(UtenteHelp u) {

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
		checkQuantity();
		return result;
	}

	// Memorizzo al massimo 50 richieste di aiuto
	private void checkQuantity() {

		Session session = HibernateUtil.openSession();
		Number res = (Number) session.createCriteria(UtenteHelp.class).setProjection(Projections.rowCount())
				.uniqueResult();

		System.out.println(res.intValue());
		if (res.intValue() == 50) {

		}
		Number minimum = (Number) session.createCriteria(UtenteHelp.class).setProjection(Projections.min("id"))
				.uniqueResult();
		System.out.println(minimum.intValue());
	}

	@SuppressWarnings("unchecked")
	public List<UtenteHelp> getTuttiHelp() {

		Session session = HibernateUtil.openSession();

		String hql = "FROM UtenteHelp";

		Transaction tx = null;
		List<UtenteHelp> result = null;

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			result = (List<UtenteHelp>) query.list();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}
}