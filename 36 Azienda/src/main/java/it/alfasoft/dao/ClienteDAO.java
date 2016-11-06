package it.alfasoft.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.alfasoft.bean.Cliente;
import it.alfasoft.utils.HibernateUtil;

public class ClienteDAO {

	
	//Inserimento di un nuovo Cliente
	public boolean creaCliente (Cliente c){
		
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		boolean result = false;
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			session.persist(c);
			tx.commit();
			result = true;
		
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	// Read di un Cliente
	public Cliente leggiCliente(String username){
		
		Session session = HibernateUtil.openSession();
		
		Transaction tx = null;
		Cliente result = null;
		String hql = "FROM Cliente Where username = :username";
		
		try {
			
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			result = (Cliente) query.uniqueResult();
			tx.commit();
			
		
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	//Resituisce la lista dei Clienti
	@SuppressWarnings("unchecked")
	public List<Cliente> getTuttiClienti() {

		Session session = HibernateUtil.openSession();
		
		String hql = "FROM Cliente";
		
		Transaction tx = null;
		List<Cliente> result = null;
		
		try {
		
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			result = (List<Cliente>) query.list();
			tx.commit();
			
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
	}

	public boolean aggiornaCliente(Cliente o) {
		// TODO Auto-generated method stub
		return false;
	}
}