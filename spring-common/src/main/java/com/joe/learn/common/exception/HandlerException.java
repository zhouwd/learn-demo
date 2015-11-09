package com.joe.learn.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.sun.media.sound.InvalidFormatException;

public class HandlerException implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory
			.getLogger(HandlerException.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	*/
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		//Map<String, Object> model = new HashMap<String, Object>();
		//model.put("ex", ex);
		if (ex instanceof HttpMessageNotReadableException) {
			response.setStatus(400);
		} else if (ex instanceof InvalidFormatException) {
			response.setStatus(400);
		}
		ex.printStackTrace();
		logger.error(ex.getMessage());
		return new ModelAndView();

	}
}