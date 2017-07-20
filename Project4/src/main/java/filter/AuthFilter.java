package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.Config;

public class AuthFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChaine)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;

		HttpSession session = req.getSession(false);
		
        String loginURI = req.getContextPath() + Config.getInstance().getProperty(Config.LOGIN);    
        
        boolean loggedIn = session != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
        	filterChaine.doFilter(request, response);
        } else {
            resp.sendRedirect(loginURI);
        }
	}

	@Override
	public void destroy() {
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}