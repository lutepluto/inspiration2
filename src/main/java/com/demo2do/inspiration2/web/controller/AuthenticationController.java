package com.demo2do.inspiration2.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AuthenticationController {
	
	private static final Log logger = LogFactory.getLog(AuthenticationController.class);
	
	/**
	 * @param request
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = {"/", "/login"})
	public String login(HttpServletRequest request, HttpSession httpSession) {
		
		AuthenticationException authenticationException = 
				(AuthenticationException) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		if (authenticationException != null) {
			
			if(logger.isErrorEnabled()) {
				logger.error("Authentication process exception: " + authenticationException.getMessage());
			}
			
		}
		
		return "login";
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/post-login")
	public String postLogin() {
		
		return "redirect: /index";
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/post-logout")
	public String postLogout() {
		
		return "redirect: /login";
	}

}
