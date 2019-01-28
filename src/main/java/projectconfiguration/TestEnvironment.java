package projectconfiguration;

public class TestEnvironment {

    public static final String SelectTestEnvironment = "SystemTest";
    public static final String http_https = "https";
    public static final String ProjectLocation = "D:\\Ohpen";

    private String baseURL = "";

    public TestEnvironment()  {
        this(SelectTestEnvironment);
    }
    public TestEnvironment(String SelectTestEnvironment)  {
        switch (SelectTestEnvironment) {
            case "SystemTest":
                // System Test Configuration
                baseURL = "api.stackexchange.com/docs";
                break;
            case "ChainTest":
                // Chain Test Configuration
                baseURL = "api.stackexchange.com/docs/chain";
                break;
            case "PreProductionTest":
                // Chain Test Configuration
                baseURL = "api.stackexchange.com/docs/preprod";
                break;
            default:
                // System Test Configuration
                baseURL = "api.stackexchange.com/docs";
                break;
        }
    }
    // Sample : "https://api.stackexchange.com/docs"
    public String getBaseURL() {
        String http_https = TestEnvironment.http_https;
        String stackExchangeURL = http_https + "://" + baseURL;
        System.out.println("stackExchangeURL : " + stackExchangeURL);
        return stackExchangeURL ;
    }
    public String getProjectLocation() {
        System.out.println("ProjectLocation : " + ProjectLocation);
        return ProjectLocation ;
    }
}

