package it.alfasoft.rubrica.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.utils.HibernateUtil;

import it.alfasoft.rubrica.bean.Voce;

public class VoceDAO {

	//Aggiunge una voce alla rubrica
	public boolean aggiungiVoce(Voce v) {
		

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean result = false;
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			session.persist(v);
			tx.commit();
			result = true;
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	//Cerca una voce di una rubrica
	public Voce trovaVoce(String nome, String cognome, int idRubrica) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Voce result = null;
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Voce where Rubrica_id_Rubrica=:x1 and nome=:x2 and cognome=:x3");
			query.setParameter("x1", idRubrica);
			query.setString("x2", nome);
			query.setString("x3", cognome);
			result = (Voce) query.uniqueResult();
			tx.commit();
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	//Aggiorna una voce
	public boolean aggiornaVoce(Voce v) {
		
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean result = false;
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			session.update(v);
			tx.commit();
			result = true;
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	//Elimina una voce
	public boolean eliminaVoce(Voce v) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean result = false;
		
		try {
		
			tx = session.getTransaction();
			tx.begin();
			session.delete(v);
			tx.commit();
			result = true;
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}
}
