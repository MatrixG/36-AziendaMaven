package it.alfasoft.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.alfasoft.bean.Cartella;
import it.alfasoft.utils.HibernateUtil;

public class CartelleDAO {

	@SuppressWarnings("unchecked")
	public List<Cartella> getCartelleUtente(int userId) {

		Session session = HibernateUtil.openSession();

		String hql = "FROM Cartella WHERE idProprietario_id = :id";

		Transaction tx = null;
		List<Cartella> result = null;

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("id", userId);
			result = (List<Cartella>) query.list();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public boolean aggiungiCartella(Cartella cartella) {

		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		boolean result = false;

		try {

			tx = session.getTransaction();
			tx.begin();
			session.persist(cartella);
			tx.commit();
			result = true;

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}
	
	public boolean aggiungiCartella(Cartella nuova, Cartella padre) {

		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		boolean result = false;

		try {

			tx = session.getTransaction();
			tx.begin();
			session.persist(nuova);
			session.update(padre);
			tx.commit();
			session.flush();
			result = true;

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}

	public Cartella getRootFolder(int userId) {

		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		Cartella result = null;
		String hql = "FROM Cartella Where idProprietario_id = :id and id = padre_id";

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("id", userId);
			result = (Cartella) query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}

	public Cartella getFolder(String nome, int idPadre) {
		
		Session session = HibernateUtil.openSession();

		Transaction tx = null;
		Cartella result = null;
		String hql = "FROM Cartella Where padre_id = :idPadre and :nome = nome";

		try {

			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setInteger("idPadre", idPadre);
			query.setParameter("nome", nome);
			result = (Cartella) query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}

}
