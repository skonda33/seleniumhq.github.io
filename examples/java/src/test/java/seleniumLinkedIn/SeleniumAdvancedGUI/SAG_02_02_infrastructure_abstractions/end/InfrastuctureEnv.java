package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_02_02_infrastructure_abstractions.end;

import java.util.HashMap;
import java.util.Map;

// mvn test -Denv=heroku
public class InfrastuctureEnv {
    public String getAdminLoginUrl() {

        String env = "github";

        if(System.getenv().containsKey("PageObjectsEnv")){
            env = System.getenv("PageObjectsEnv");
        }

        if(System.getProperties().containsKey("env")){
            env=System.getProperty("env");
        }

        Map<String, String> urls = new HashMap<>();
        urls.put("heroku", "https://testpages.herokuapp.com/styled/cookies/adminlogin.html");
        urls.put("github", "https://eviltester.github.io/simpletodolist/adminlogin.html");

        return urls.get(env);
    }

    //String env = "https://testpages.herokuapp.com/styled/cookies/adminlogin.html";
    //String env = "https://eviltester.github.io/simpletodolist/adminlogin.html";

}
