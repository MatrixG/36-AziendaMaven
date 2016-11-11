package it.alfasoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.alfasoft.bean.Utente;
import it.alfasoft.utils.HibernateUtil;

public class UtenteDAO {

	// Init admin
	public boolean initAdmin(Utente u) {

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

	// Cerca se un utente è presente nel DB
	public Utente loginUtente(Utente u) {

		Session session = HibernateUtil.openSession();
		String hql = "From Utente Where username = :username AND password = :password";
		Transaction tx = null;
		Utente result = null;

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("username", u.getUsername());
			query.setParameter("password", u.getPassword());
			result = (Utente) query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	// Ritorna "true" se lo username non è usato
	public boolean checkUsername(String username) {

		Session session = HibernateUtil.openSession();
		String hql = "From Utente Where username = :username";
		Transaction tx = null;
		boolean result = true;

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			if ((Utente) query.uniqueResult() != null)
				result = false;
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	// leggo un utente con lo username
	public Object leggiUtente(String username) {

		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		Utente result = null;
		String hql = "FROM Utente Where username = :username";

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			result = (Utente) query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}

	// Remove a user from database
	public boolean rimuoviUtente(String email) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean result = false;

		try {

			tx = session.getTransaction();
			tx.begin();
			Utente u = (Utente) leggiUtente(email);
			session.delete(u);
			tx.commit();
			result = true;

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public boolean setAdmin(Utente u) {

		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		boolean result = false;

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update Utente set id = :id" + " where username = :username");
			query.setParameter("id", 1);
			query.setParameter("username", u.getUsername());
			int res = query.executeUpdate();
			if (res == 1)
				result = true;
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}
}
