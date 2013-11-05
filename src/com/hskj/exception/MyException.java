package com.hskj.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyException extends Exception implements AccessDeniedHandler {
	private static final long serialVersionUID = 1L;

	public MyException(String ex) {
		System.out.println(ex);
	}

	@Override
	public void handle(HttpServletRequest arg0, HttpServletResponse arg1,
			AccessDeniedException arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}


}
