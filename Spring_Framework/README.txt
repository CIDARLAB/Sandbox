This application is meant to demonstrate Spring Boot. It is built with Maven and generates a site that shows the text 
"Hello Spring" as well as a simple counter. There are 3 main java classes: Application.java, Counting.java, and
CountingController.java. Application.java starts the application, Counting,java handles the functionality of the counter,
and CountingController.java is the spring controller which handles the POST and GET calls for Counting.java. 
CountingController.java uses @ResquestMapping to set which requests get mapped to which functions. There is also an
application.properties file which sets the location for the jsp files.



Running the application with an IDE(Netbeans):
1. Create a New Project in Netbeans.
2. Under Maven select "Project with Existing POM" and then choose the HelloSpring pom file.
3. Clean, build, and run.

Running the application from the command line:
1. In the Spring_Framework file run the command "mvn package && java -jar target/HelloSpring-1.3.5.RELEASE.jar".
