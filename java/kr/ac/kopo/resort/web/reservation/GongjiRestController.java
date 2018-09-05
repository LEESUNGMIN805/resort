package kr.ac.kopo.resort.web.reservation;
//package kr.ac.kopo.resort.web.gongji;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import kr.ac.kopo.resort.domain.Reservation;
//import kr.ac.kopo.resort.service.GongjiService;
//
//@RestController
//public class GongjiRestController {
//	
//	private static final Logger Logger = LoggerFactory.getLogger(GongjiRestController.class);
//	
//	@Autowired
//	private GongjiService gongjiService;
//	
//    public ResponseEntity<Reservation> getGongji (int id)
//    {
//    	Logger.info("Fetching Gongji with id " + id);
//    	Reservation gongji = gongjiService.selectOne(id);
//    	if(gongji == null) {
//    		Logger.info("Gongji with id " + id + " not found");
//    		return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
//    	}
//    	return new ResponseEntity<Reservation>(gongji, HttpStatus.OK);
//    }
//    
//    @RequestMapping(value = "/api/gongji/one/xml/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Reservation> getGongjiXml (@PathVariable("id") int id)
//    {
//    	return getGongji(id);
//    }
//    
//    
//    @RequestMapping(value = "/api/gongji/one/jason{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Reservation> getGongjiJson(@PathVariable("id") int id){
//    	return getGongji(id);
//    }
//}
