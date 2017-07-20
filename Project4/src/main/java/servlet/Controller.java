package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import commands.ICommand;
import manager.Message;

public class Controller extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(Controller.class);
    ControllerHelper controllerHelper = ControllerHelper.getInstance();
	private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        try {
            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
        	logger.error(e);
            request.setAttribute("messageError", Message.getInstance().getProperty(Message.SERVLET_EXECPTION));
        } catch (IOException e) {
        	logger.error(e);
            request.setAttribute("messageError", Message.getInstance().getProperty(Message.IO_EXCEPTION));
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
