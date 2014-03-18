package com.demo2do.inspiration2.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class AuthenticationController {
	
	private static final Log logger = LogFactory.getLog(AuthenticationController.class);
	
	/**
	 * session invalid redirect
	 * 
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/timeout")
	public String timeout(RedirectAttributes redirectAttributes) {
		
		logger.info("Session timeout... The system will redirect to login page.");
		
		// add a flag into session to display on login page
		redirectAttributes.addFlashAttribute("timeoutErrorMessage", "security.authentication.timeout");
		
		return "redirect:/login";
	}
	
	/**
	 * @param request
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = {"/", "/login"})
	public String login(HttpServletRequest request, HttpSession httpSession, @ModelAttribute("timeoutErrorMessage") String timeoutErrorMessage) {
		
		AuthenticationException authenticationException = 
				(AuthenticationException) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		// when authentication exception is found, setting up error message to display
		if (authenticationException != null) {
			
			if(logger.isErrorEnabled()) {
				logger.error("Authentication process exception: " + authenticationException.getMessage());
			}
			
			request.setAttribute("errorMessage", "security.authentication.fail");
			
			// remove AuthenticationException from httpSession
			httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			
			return "login";
		}
		
		if (StringUtils.isNotEmpty(timeoutErrorMessage)) {
			
			request.setAttribute("errorMessage", timeoutErrorMessage);
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
