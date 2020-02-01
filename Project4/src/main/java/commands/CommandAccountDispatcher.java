package commands;
// TODO доробити потім завдання

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Config;

public class CommandAccountDispatcher implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return Config.getInstance().getProperty(Config.DISPATCHER_ACCOUNT);
	}
}