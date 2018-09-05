package kr.ac.kopo.resort.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.resort.domain.Room;

@Transactional
@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM Room";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public Room selectOne(long id) {
		String hql = "FROM Room r WHERE r.id = " + id;
		Query query = getSession().createQuery(hql);
		return (Room) query.uniqueResult();
		
//		return (Room) query.list().get(0);
		
//		return (Rooms) getSession().get(Rooms.class, id);
	}

	@Override
	public List<Room> selectAll() {
		String hql = "FROM Room";
		Query query = getSession().createQuery(hql);
		return query.list();
		
//		return getSession().createCriteria(Rooms.class).list();
	}
	
	@Override
	public List<Room> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM Room ORDER BY no";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}

	@Override
	public int createOne(Room room) {
		return (int) getSession().save(room);
		
//		session.flush();
//		session.close();
	}

	@Override
	public void updateOne(Room room) {
		getSession().saveOrUpdate(room);
	}

	@Override
	public void deleteOne(Room room) {
		getSession().delete(room);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM Room";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}
	
}
