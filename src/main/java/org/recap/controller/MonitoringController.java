package org.recap.controller;

import org.recap.PropertyKeyConstants;
import org.recap.ScsbConstants;
import org.recap.security.UserManagementService;
import org.recap.util.MonitoringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/monitoring")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class MonitoringController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringController.class);

    @Value("${" + PropertyKeyConstants.MONITORING_EMBED_UI_URL + "}")
    private String scsbURL;

    @Value("${" + PropertyKeyConstants.MONITORING_EMBED_DOCKER_URL + "}")
    private String dockerURL;

    @Value("${" + PropertyKeyConstants.MONITORING_EMBED_AWS_URL + "}")
    private String awsURL;

    @Value("${" + PropertyKeyConstants.LOGGING_UI_URL + "}")
    private String loggingURL;

    @Value("${" + PropertyKeyConstants.LOGGING_EMBED_UI_URL + "}")
    private String embedLogURL;


    @Autowired
    private MonitoringUtil monitoringUtil;

    @Autowired
    private  UserManagementService userManagementService;

    /**
     * Display All Monitoring url's
     *
     * @return the boolean
     */
    @GetMapping("/monitoring")
    public boolean monitoring(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        boolean authenticated = getUserAuthUtil().isAuthenticated(request, ScsbConstants.SCSB_SHIRO_MONITORING_URL);
        if (authenticated) {
            return true;
        }
        return userManagementService.unAuthorizedUser(session, "Monitoring", logger);
    }

    @GetMapping("/logging")
    public boolean logging(HttpServletRequest request) {
        boolean authenticated = getUserAuthUtil().isAuthenticated(request, ScsbConstants.SCSB_SHIRO_LOGGING_URL);
        HttpSession session = request.getSession(false);
        if (authenticated) {
            return true;
        }
        return userManagementService.unAuthorizedUser(session, "Logging", logger);
    }
    @GetMapping("/properties")
    public Map<String,String> properties(){
        Map<String,String> prop = new HashMap<>();
        prop.put("scsbURL",scsbURL);
        prop.put("dockerURL",dockerURL);
        prop.put("awsURL",awsURL);
        prop.put("loggingURL",loggingURL);
        prop.put("embedLogURL",embedLogURL);
        return prop;
    }
}
