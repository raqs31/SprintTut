package com.mario.web.co.errors;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by raqsW on 2016-08-22.
 */

@ControllerAdvice
public class ErrorHandlerCO {

	private static final Logger logger = Logger.getLogger( ErrorHandlerCO.class );
	private static final String PATH = "errors/error";

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception ex) {
		logger.error("Error", ex);

		ModelAndView modelAndView = new ModelAndView();
		HttpStatus status = getStatus(req);

		modelAndView.setViewName(PATH);
		modelAndView.addObject("stack", ex);
		modelAndView.addObject("errStat", status);

		return modelAndView;
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
}
