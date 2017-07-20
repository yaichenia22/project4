package commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	
	/*
	 * Method that implements command pattern
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
