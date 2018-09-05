package kr.ac.kopo.resort.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.resort.domain.Reservation;

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM Reservation";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public Reservation selectOne(long id) {
		String hql = "FROM Reservation r WHERE r.id = " + id;
		Query query = getSession().createQuery(hql);
		return (Reservation) query.uniqueResult();
		
//		return (User) query.list().get(0);
		
//		return (Users) getSession().get(Users.class, id);
	}

	@Override
	public List<Reservation> selectAll() {
		String hql = "FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.list();
		
//		return getSession().createCriteria(Users.class).list();
	}
	
	@Override
	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM Reservation ORDER BY id desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}

	@Override
	public int createOne(Reservation reservation) {
		return (int) getSession().save(reservation);
		
//		session.flush();
//		session.close();
	}

	@Override
	public void updateOne(Reservation reservation) {
		getSession().saveOrUpdate(reservation);
	}

	@Override
	public void deleteOne(Reservation reservation) {
		getSession().delete(reservation);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}
	
}
