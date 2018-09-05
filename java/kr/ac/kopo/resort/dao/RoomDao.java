package kr.ac.kopo.resort.dao;

import java.util.List;

import kr.ac.kopo.resort.domain.Room;
import kr.ac.kopo.resort.domain.User;

public interface RoomDao {
	Long count();
	Room selectOne(long id);
	List<Room> selectAll();
	List<Room> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Room room);
	void updateOne(Room room);
	void deleteOne(Room room);
	int deleteAll();
}
