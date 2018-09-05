package kr.ac.kopo.resort.vo;

import java.util.Date;

public class ReservationVO {

	    private String date;
	    private String reservedRoomCheck1;
	    private String reservedRoomCheck2;
	    private String reservedRoomCheck3;

	    public String getReservedRoomCheck1() {
			return reservedRoomCheck1;
		}

		public void setReservedRoomCheck1(String reservedRoomCheck1) {
			this.reservedRoomCheck1 = reservedRoomCheck1;
		}

		public String getReservedRoomCheck2() {
			return reservedRoomCheck2;
		}

		public void setReservedRoomCheck2(String reservedRoomCheck2) {
			this.reservedRoomCheck2 = reservedRoomCheck2;
		}

		public String getReservedRoomCheck3() {
			return reservedRoomCheck3;
		}

		public void setReservedRoomCheck3(String reservedRoomCheck3) {
			this.reservedRoomCheck3 = reservedRoomCheck3;
		}

		public ReservationVO(String date) {
	        this.date = date;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }
	
}
