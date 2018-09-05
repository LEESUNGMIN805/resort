package kr.ac.kopo.resort.service;

import java.util.List;

import kr.ac.kopo.resort.domain.Reservation;
import kr.ac.kopo.resort.vo.ReservationVO;

public interface ReservationService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	Reservation selectOne(long id);
	List<Reservation> selectAll();
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Reservation reservation);
	void updateOne(Reservation reservation);
	void deleteOne(Reservation reservation);
	int deleteAll();
//	PaginationVO calcPagination(int page, int itemSizePerPage);
	
	//-------------------complex--------------------------------------------------------
	boolean isReservationExist(Reservation reservation);
	void deleteOne(long id);
	List<ReservationVO> calc();
//	Reservation selectOneWithCheckPoint(long userId, long reservationId);
}
