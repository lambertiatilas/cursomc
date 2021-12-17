package com.nelioalves.cursomc.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandlerJwt implements AccessDeniedHandler {
	
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
    	response.setStatus(403);
		response.setContentType("application/json");
		response.getWriter().append(json());
    }
    
    private String json() {
		long date = new Date().getTime();
		return "{\"timestamp\": " + date + ", " + "\"status\": 403, " + "\"error\": \"Acesso negado\"}";
	}
}