package manager;

import java.util.Locale;
import java.util.ResourceBundle;

public class Config {

    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "config";
    public static final String DRIVER = "DRIVER";
    public static final String URL = "URL";
    public static final String TENANT_MAIN = "TENANT_MAIN";
    public static final String ERROR = "ERROR";
    public static final String LOGIN = "LOGIN";
    public static final String REQUESTS_FOR_TENANT = "REQUESTS_FOR_TENANT";
    public static final String DISPATCHER_MAIN = "DISPATCHER_MAIN";
    public static final String CREATE_REQUEST = "CREATE_REQUEST";
    public static final String CREATE_WORKING_PLAN = "CREATE_WORKING_PLAN";
    public static final String TENANT_ACCOUNT = "TENANT_ACCOUNT";
    public static final String DISPATCHER_ACCOUNT = "DISPATCHER_ACCOUNT";
    public static final String REQUEST_MANAGER = "REQUEST_MANAGER";
    public static final String TENANT_MANAGER = "TENANT_MANAGER";
    public static final String EMPLOYEES = "EMPLOYEES";
    public static final String WORKPLANS_MANAGER = "WORKPLANS_MANAGER";
    public static final String REQUEST_FOR_DISPATCHER ="REQUEST_FOR_DISPATCHER";

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault());
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
