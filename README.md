To Build Application please run the following command inside your root directory:

$ mvn clean package

The executable JAR file is now available in the target directory and we may start up the application by executing the following command on the command line:

$ java -jar simple-route-0.0.1-SNAPSHOT.jar

After init that you can open your browser and go to this url : http://localhost:8080/route/{origin}/{destination}

If the countries you want have access to each other, you will be shown a list.

#Example
For example, if you go to the following address:
http://localhost:8080/routing/CZE/AUT

The response will be this.
{"route":["CZE","DEU","AUT"]}

But if there is no path between your points, you will get an error of 400.


