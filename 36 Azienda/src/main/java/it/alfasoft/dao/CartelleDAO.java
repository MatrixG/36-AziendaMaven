package it.alfasoft.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.alfasoft.bean.Cartella;
import it.alfasoft.utils.HibernateUtil;

public class CartelleDAO {

	@SuppressWarnings("unchecked")
	public List<Cartella> getRootId(int userId) {
		
		Session session = HibernateUtil.openSession();

		String hql = "FROM Cartella WHERE idProprietario = :id";

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

}
