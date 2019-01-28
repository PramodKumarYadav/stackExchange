package projectconfiguration;

public class TestEnvironment {

    public static final String SelectTestEnvironment = "SystemTest";
    public static final String http_https = "https";
    public static final String ProjectLocation = "D:\\petstoreSwagger";

    private String baseURL = "";

    public TestEnvironment()  {

        this(SelectTestEnvironment);
    }
    public TestEnvironment(String SelectTestEnvironment)  {
        switch (SelectTestEnvironment) {
            case "SystemTest":
                // System Test Configuration
                baseURL = "petstore.swagger.io/v2";
                break;
            case "ChainTest":
                // Chain Test Configuration
                baseURL = "petstore.swagger.io/v3";
                break;
            case "PreProductionTest":
                // Chain Test Configuration
                baseURL = "petstore.swagger.io/v4";
                break;
            default:
                // System Test Configuration
                baseURL = "petstore.swagger.io/v2";
                break;
        }
    }
    // Sample : "https://petstore.swagger.io/v2/"
    public String getBaseURL() {
        String http_https = TestEnvironment.http_https;
        String swaggerURL = http_https + "://" + baseURL;
        System.out.println("swaggerURL : " + swaggerURL);
        return swaggerURL ;
    }
    public String getProjectLocation() {
        System.out.println("ProjectLocation : " + ProjectLocation);
        return ProjectLocation ;
    }
}

