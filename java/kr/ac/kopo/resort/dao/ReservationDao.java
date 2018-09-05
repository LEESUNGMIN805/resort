package kr.ac.kopo.resort.dao;

import java.util.List;

import kr.ac.kopo.resort.domain.Reservation;

public interface ReservationDao {
	Long count();
	Reservation selectOne(long id);
	List<Reservation> selectAll();
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Reservation reservation);
	void updateOne(Reservation reservation);
	void deleteOne(Reservation reservation);
	int deleteAll();
}
