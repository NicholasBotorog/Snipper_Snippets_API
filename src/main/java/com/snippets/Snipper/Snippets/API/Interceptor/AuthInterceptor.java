package com.snippets.Snipper.Snippets.API.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        if((authHeader !=null) && (authHeader.startsWith("Basic"))){
            authHeader = authHeader.substring(6).trim();
            byte[] decodedAuthHeader = java.util.Base64.getDecoder().decode(authHeader);
            String[] authHeaderValues = new String(decodedAuthHeader).split(":");
            request.setAttribute("Username", authHeaderValues[0]);
            request.setAttribute("Password", authHeaderValues[1]);
        }
        return true;
    }
}
