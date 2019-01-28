# stackExchange Website : https://api.stackexchange.com/docs
This is a four hour project for stackExchange API. I build the framework for REST API using RestAssured in IntelliJ - Java using Maven. I used Junit for assertions.

# FRAMEWORK :
In the framework, the key components are:

# PROJECT CONFIGURATION:
Keep a test environment class to maintain project configuration. Note: You dont need it here since you have access to only one version of stackexchange.com (The production version) but in a real life project, you would want to use the same framework to test in System Test environment, Chain test environment and say pre-production environment (or more). Thus I store all the endpoints at one place for each test env to keep the framework flexible enough to work in all test enviroments and avoid hardcodig in classes (say in ST, Chain test, pre prod).

# Data driven tests
Generally, when I work with Soap requests, I create test requests using a stubbing tool. Here due to time crunch, I used a randaom number generator to create data driven tests under src -> test -> comments -> TestGetCommentsByIDs class. Both methods are basic examples for data driven test for search with single ID and multiple ID. In real production project, I will most probably, come up with another approach. 

# Building Expected Results:
I like to do more tests than simply assert responses as OK, not OK response. I like to validate the body of the response as well. In past for Soap reqests I used functional specifications to do this. For Rest, I would build a function or Json schema validation as mentioned in : https://www.baeldung.com/rest-assured-json-schema . For now since my time is running up, I am leaving this part only as explaination. 

# TEST EXECUTION:
For this, 
-> In Main: I create general purpose functions that contains generic code that I can use in multiple tests. 
-> In Test: I create all my Junit tests, that can use the above generic code and the data from test database, to create simple yet powerful tests.

# TEST REPORT :
I use the inbuilt test reports options in IntelliJ to generate my log results into txt file. I do this using Run -> Edit Configuration -> Select "Configuraiton" at Class level (or at method level), give a name of file and location under "Logs" section.
All reports are then generated at -> D:\petstoreSwagger\TestResults 
NOTE: 
  -> If you run the tests from class level, you will see the results in folders -> D:\petstoreSwagger\TestResults\className
   -> If you run the tests from package level, you will see the result in package folder -> D:\petstoreSwagger\TestResults\stackExchange

# VERSION CONTROL :
I use the inbuilt function in intelliJ to add a GIT repository for version control using (VCS -.GIT.). Once done, I push the changes to remote using command line to my github repository (https://github.com/PramodKumarYadav/Ohpen/)

# CI Integration!
Since all the tests are created in Maven and all classes are named with Test in them, we can run the tests from command line using Maven - Test. 
