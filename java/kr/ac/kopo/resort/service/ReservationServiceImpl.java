package kr.ac.kopo.resort.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.resort.dao.ReservationDao;
import kr.ac.kopo.resort.dao.UserDao;
import kr.ac.kopo.resort.domain.Reservation;
import kr.ac.kopo.resort.vo.ReservationVO;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Long count() {
		return reservationDao.count();
	}

	@Override
	public Reservation selectOne(long id) {
		return reservationDao.selectOne(id);
	}

	@Override
	public List<Reservation> selectAll() {
		return reservationDao.selectAll();
	}

	@Override
	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
		return reservationDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(Reservation reservation) {
		return reservationDao.createOne(reservation);
	}

	@Override
	public void updateOne(Reservation reservation) {
		reservationDao.updateOne(reservation);
	}

	@Override
	public void deleteOne(Reservation reservation) {
		reservationDao.deleteOne(reservation);
	}

	@Override
	public int deleteAll() {
		return reservationDao.deleteAll();
	}
	
	@Override
	public boolean isReservationExist(Reservation reservation) {
		Reservation u = reservationDao.selectOne(reservation.getId());
		return u == null ? false : true;
	}
	
	@Override
	public void deleteOne(long id) {
		Reservation u = reservationDao.selectOne(id);
		reservationDao.deleteOne(u);
	}
	
	@Override
    public List<ReservationVO> calc() {
        
        List<ReservationVO> reservations = new ArrayList<ReservationVO>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Reservation> reservationData = new ArrayList<Reservation>();
        reservationData = reservationDao.selectAll();
        
        for(int i=0; i<30; i++) {
            reservations.add(new ReservationVO(dformat.format(cal.getTime())));
            reservations.get(i).setReservedRoomCheck1("예약가능");
            reservations.get(i).setReservedRoomCheck2("예약가능");
            reservations.get(i).setReservedRoomCheck3("예약가능");
            for(int j=0; j<reservationData.size(); j++) {
                if(reservations.get(i).getDate().equals(dformat.format(reservationData.get(j).getDate()))) {
                	if(reservationData.get(j).getRoom().getId()==1) {
                        reservations.get(i).setReservedRoomCheck1(reservationData.get(j).getUser().getName());
                    } else if (reservationData.get(j).getRoom().getId()==2) {
                    	reservations.get(i).setReservedRoomCheck2(reservationData.get(j).getUser().getName());
                    } else if (reservationData.get(j).getRoom().getId()==3) {
                    	reservations.get(i).setReservedRoomCheck3(reservationData.get(j).getUser().getName());
                    }
                }
            }
            cal.add(cal.DATE,+1);    
        }

        return reservations;
    }

	

}
