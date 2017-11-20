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
		HttpSession session = req.getSession(true);		
        String loginURI = req.getContextPath() + Config.getInstance().getProperty(Config.LOGIN);
        
        if (session.getAttribute("user") == null) {
        	if (isCommandLogin(req)) {
        		filterChaine.doFilter(request, response);
        	} else {
        		if (req.getRequestURI().equals(loginURI)) {
        			filterChaine.doFilter(request, response);
        		} else {
        			resp.sendRedirect(loginURI);
        		}
        	}
        } else {
        	filterChaine.doFilter(request, response);
        }
	}
	
	private boolean isCommandLogin(HttpServletRequest request) {
		String parameter = request.getParameter("command");
		if (parameter == null || !parameter.equals("login")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void destroy() {
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}