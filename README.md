#Run the following command inside your application's root directory:

$ mvn clean package

#The executable JAR file is now available in the target directory and we may start up the application by executing the following command on the command line:

$ java -jar your-app.jar

At this point, you still need to invoke the Java interpreter with the -jar option. There are many reasons why it would be preferable to have your app started by being able to invoke it as a service.
