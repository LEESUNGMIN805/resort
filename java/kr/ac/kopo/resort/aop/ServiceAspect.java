//package kr.ac.kopo.resort.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import kr.ac.kopo.resort.domain.Reservation;
//import kr.ac.kopo.resort.domain.User;
//
//@Aspect
//@Component
//public class ServiceAspect {
//	
//	// kr.ac.kopo.board.aop.UserServiceImpl.selectOne
//	// *..*Service..selectOne
//	
////	@Before("execution(* selectOne(long))")
//	@Before("execution(* *..*Service..selectOne(long))")
//	public void before() {
//		System.out.println("selectOne Before! ***");
//	}
//	
//	@After("execution(* selectOne(long))")
//	public void after() {
//		System.out.println("selectOne After! ***");
//	}
//	
//	@AfterReturning(value="execution(* selectOne(long))", returning="gongji")
//	public void afterReturning(Reservation gongji) {
//		System.out.println("selectOne AfterReturning! ***");
//	}
//
//	@Around("execution(kr.ac.kopo.board.domain.User selectOne(long))")
//	public User around(ProceedingJoinPoint user) throws Throwable {
//		System.out.println("selectOne Around! before ***");
//		User g = (User)user.proceed();
//		System.out.println("selectOne Around! after ***");
//		return g;
//	}
//	
//	@AfterThrowing(value="execution(* selectOne(long))", throwing="ex")
//	public void afterThrowing(Throwable ex) {
//		System.out.println("selectOne Throwing! ***");
//	}
//}
