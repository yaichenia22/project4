package servlet;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import commands.*;

public class ControllerHelper {
    
	private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    private ControllerHelper() {
        commands.put("login", new CommandLogin());
        commands.put("logout", new CommandLogout());
        commands.put("missing", new CommandMissing());
        commands.put("tenantHome", new CommandTenantHome());
        commands.put("tenantRequest", new CommandRequestTenant());
        commands.put("tenantAccount", new CommandAccountTenant());
        commands.put("goToCreateRequest", new CommandGoToCreateRequest());
        commands.put("createRequest", new CommandCreateRequest());
        commands.put("dispatcherMain", new CommandDispatcherMain());
        commands.put("dispatcherAccount", new CommandAccountDispatcher());
        commands.put("requestManager", new CommandRequestManager());
        commands.put("workplanManager", new CommandWorkplansManager());
        commands.put("requestForDispatcher", new CommandRequestForDispatcher());
        commands.put("deleteRequest", new CommandDeleteRequest());
        commands.put("goToCreatePlan", new CommandGoToCreatePlan());
        commands.put("createPlan", new CommandCreatePlan());
        commands.put("deleteWorkplan", new CommandDeleteWorkplan());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = commands.get("missing");
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}