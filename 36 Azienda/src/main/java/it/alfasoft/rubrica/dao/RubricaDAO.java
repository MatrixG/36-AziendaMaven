package it.alfasoft.rubrica.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.utils.HibernateUtil;

import it.alfasoft.rubrica.bean.Rubrica;
import it.alfasoft.rubrica.bean.Voce;

public class RubricaDAO {

	//Aggiunge una rubrica
	public boolean creaRubrica(Rubrica r) {

		boolean result = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(r);
			result = true;
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return result;
	}

	// Cerca se la rubrica è presente

	public Rubrica trovaRubricaConId(int idRubrica) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Rubrica r = null;
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			r = session.get(Rubrica.class, idRubrica);
			tx.commit();
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return r;

	}

	// Aggiorna una rubrica
	public boolean aggiornaRubrica(Rubrica r) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean result = false;
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			session.update(r);
			tx.commit();
			result = true;
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;

	}

	// Ritorna una lista con tutte le voci della rubrica
	@SuppressWarnings("unchecked")
	public List<Voce> getVociRubrica(int id) {
		
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Voce> voci = null;
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Rubrica where id=:x");
			query.setParameter("x", id);
			voci = (List<Voce>) query.list();
			tx.commit();
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return voci;
	}

}
