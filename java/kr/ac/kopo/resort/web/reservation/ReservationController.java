package kr.ac.kopo.resort.web.reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.resort.domain.Reservation;
import kr.ac.kopo.resort.domain.Room;
import kr.ac.kopo.resort.domain.User;
import kr.ac.kopo.resort.service.ReservationService;
import kr.ac.kopo.resort.service.RoomService;
import kr.ac.kopo.resort.service.UserService;
import kr.ac.kopo.resort.vo.ReservationVO;

@Controller
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/reservation_list", method = RequestMethod.GET)
	public String home(Locale locale, @RequestParam Map<String, String>param, Model model) {
		logger.info("reservation list");	// 자바 콘솔에다 출력하기
		
		// $$$$$$$$$$$$$ 페이지네이션을 위한 부분 $$$$$$$$$$$$$$$$$$
//		int page = Integer.parseInt(param.get("page"));	// param은 get방식의 파라미터 가져오기이다.
//		model.addAttribute("page", page);	// model객체는 파라미터를 담는 객체이다. 앞에는 명칭이다.
//		
//		int itemSizePerPage = Integer.parseInt(param.get("itemSizePerPage"));
//		model.addAttribute("itemSizePerPage", itemSizePerPage);
//		
//		logger.info("page : " + page);
//		logger.info("itemSizePerPage : " + itemSizePerPage);
//		
//		Long count = reservationService.count();	// reservationService객체의 count메소드를 호출. 구현은 ReservationServiceImpl에 해놓았다.
//		model.addAttribute("count", count);	// 테이블의 로우갯수를 샌것이 count이다.
//		
//		List<Reservation> reservationList = reservationService.selectAllByPagination(page, itemSizePerPage);
//		model.addAttribute("reservationList", reservationList);
		
		List<ReservationVO> reservations = (List<ReservationVO>) reservationService.calc();
		model.addAttribute("reservations", reservations);
	    
//	    PaginationVO pagination = reservationService.calcPagination(page, itemSizePerPage);
//	    model.addAttribute("pagination", pagination);
				
		return "reservation/list";
		
	}
	
	@RequestMapping(value = "/reservation_view", method = {RequestMethod.POST, RequestMethod.GET})
	public String reservation_view(Locale locale, @RequestParam Map<String, String>param, Model model) {
		
//		Reservation g = reservationService.selectOneWithCheckPoint(userId, reservationId);
//		Reservation g = reservationService.selectOneWithCheckPoint(1, 1);
		
		int id = Integer.parseInt(param.get("id"));
	    Reservation selectOne = reservationService.selectOne(id);
	    model.addAttribute("selectOne", selectOne);
	    
	    return "reservation/view";
	}
	
	@RequestMapping(value = "/reservation_insert", method = {RequestMethod.POST, RequestMethod.GET})
	public String reservation_insert(Locale locale, @RequestParam Map<String, String>param, Model model) {

	    String reserveDate = param.get("reserveDate");
	    model.addAttribute("reserveDate", reserveDate);
	    
	    String userName = userService.selectOne(1).getName();
	    model.addAttribute("userName", userName);
		
//		int maxid=reservationService.maxid();
//		model.addAttribute("maxid", maxid);
//		logger.info("maxid : " + maxid);
		
	    return "reservation/insert";
	}
	
	@RequestMapping(value = "/reservation_write", method = {RequestMethod.POST, RequestMethod.GET})
	public String reservation_write(Locale locale, @RequestParam Map<String, String>param, Model model) throws ParseException {
		
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date nowdate = new Date();
	    
//		String userName = param.get("userName");
		User roomUser = userService.selectOne(1);
		
		Reservation reservation = new Reservation();
		reservation.setUser(roomUser);
		String strReserveDate = param.get("reserveDate");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd"); 
		Date reserveDate = dt.parse(strReserveDate); 
		
		reservation.setDate(reserveDate);
		
		String roomType = param.get("room");
		long longRoomType = Long.parseLong(roomType);
		Room room = new Room();
		room = roomService.selectOne(longRoomType);
		reservation.setRoom(room);
		
		String tel = param.get("tel");
		reservation.setTel(tel);
		
		String depositor = param.get("depositor");
		reservation.setDepositor(depositor);
		
		String comment = param.get("comment");
		reservation.setComment(comment);
		
		reservationService.createOne(reservation);
		
//		List<ReservationVO> reservations = (List<ReservationVO>) reservationService.calc();
//		model.addAttribute("reservations", reservations);

		return "redirect:/reservation_list";
	    
	}
	
	
	@RequestMapping(value = "/reservation_reinsert", method = RequestMethod.GET)
	public String reservation_reinsert(Locale locale, @RequestParam Map<String, String>param, Model model) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date nowdate = new Date();
	    model.addAttribute("date", nowdate);
	    
	    int nodeid = Integer.parseInt(param.get("nodeid"));
	    int newnodeid = nodeid+1;
	    model.addAttribute("newnodeid", newnodeid);
	    
	    int id = Integer.parseInt(param.get("id"));
	    Reservation selectOne = reservationService.selectOne(id);
	    selectOne.setDate(nowdate);
	    model.addAttribute("selectOne", selectOne);
		
//		int maxid=reservationService.maxid();
//		model.addAttribute("maxid", maxid);
//		logger.info("maxid : " + maxid);
		
	    return "reservation/reinsert";
	}
	
	@RequestMapping(value = "/reservation_reinsertwrite", method = {RequestMethod.POST, RequestMethod.GET})
	public String reservation_reinsertwrite(Locale locale, @RequestParam Map<String, String>param, Model model) {
		
//		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
//	    String date = formatter.format(new java.util.Date());
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date nowdate = new Date();
		
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date =  transFormat.parse(param.get("date"));
	    int newnodeid = Integer.parseInt(param.get("newnodeid"));
	    
	    int rootid = Integer.parseInt(param.get("rootid"));
		String title = param.get("title");
		int viewcnt = Integer.parseInt(param.get("viewcnt"));
		String content = param.get("content");
		int id = Integer.parseInt(param.get("id"));
		
		Reservation reservation = new Reservation();
		Reservation rootid1 = reservationService.selectOne(rootid);
		
//		reservation.setId(id);
//		reservation.setTitle(title);
//		reservation.setContent(content);
//		reservation.setViewcnt(viewcnt);
//		reservation.setDate(nowdate);
//		reservation.setRootid(rootid1);
//		reservation.setNodeid(newnodeid);
//		reservation.setRecnt(1);
		
		int createOne = reservationService.createOne(reservation);
//	    model.addAttribute("createOne", createOne);
		
		
	    return "redirect:/reservation_list?page=1&itemSizePerPage=2";
	    
	}
	
	
	@RequestMapping(value = "/reservation_delete", method = RequestMethod.GET)
	public String reservation_delete(Locale locale, @RequestParam Map<String, String>param, Model model) {

		int id = Integer.parseInt(param.get("id"));
	    reservationService.deleteOne(id);
//	    model.addAttribute("selectOne", selectOne);
	    
	    return "redirect:/reservation_list?page=1&itemSizePerPage=2";
	}
	
	@RequestMapping(value = "/reservation_update", method = RequestMethod.GET)
	public String reservation_update(Locale locale, @RequestParam Map<String, String>param, Model model) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date nowdate = new Date();
		
		int id = Integer.parseInt(param.get("id"));
		
	    Reservation selectOne = reservationService.selectOne(id);
	    selectOne.setDate(nowdate);
	    model.addAttribute("selectOne", selectOne);
	    logger.info("id : " + id);
	    logger.info("date : " + nowdate);
	    
	    return "reservation/update";
	}
	
	@RequestMapping(value = "/reservation_updatewrite", method = RequestMethod.POST)
	public String reservation_updatewrite(Locale locale, @RequestParam Map<String, String>param, Model model) {
		
//		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
//	    String date = formatter.format(new java.util.Date());
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date nowdate = new Date();
		
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date =  transFormat.parse(param.get("date"));
		
		String title = param.get("title");
		String content = param.get("content");
		int id = Integer.parseInt(param.get("id"));
		
		int rootid = Integer.parseInt(param.get("rootid"));
		
	    Reservation reservation = reservationService.selectOne(id);
		
//		reservation.setTitle(title);
//		reservation.setContent(content);
//		reservation.setDate(nowdate);
		logger.info("rootid : " + rootid);
		logger.info("id : " + id);
		
		reservationService.updateOne(reservation);
//	    model.addAttribute("createOne", createOne);
	    
	    return "redirect:/reservation_list?page=1&itemSizePerPage=2";
	    
	}

}
