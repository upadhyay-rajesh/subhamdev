package com.facebookrest.utility;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
//import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.facebookrest.entity.FacebookUser;

@Aspect
@Component
public class FacebookServiceAspects {
	public static Logger log=Logger.getLogger("FacebookService");
	
	@Before(value="execution(* com.facebookrest.service.FacebookService.*(..)) and args(fuser)")
	public void beforeExecution(JoinPoint jj,FacebookUser fuser) {
		log.info("before execusion of "+jj.getSignature());
		log.info("creating new facebookuser profile for "+fuser.getEmail());
	}
	
	@After(value="execution(* com.facebookrest.service.FacebookService.*(..)) and args(fuser)")
	public void bExecution(JoinPoint jj,FacebookUser fuser) {
		log.info("after execusion of "+jj.getSignature());
		log.info("after creating profile for "+fuser.getEmail());
	}

}
