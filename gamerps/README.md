# Rock-paper-scissors game

This is an extensible and scalable Rock-paper-scissors game implementation. 

## How to build/run this project
Currently built and execute the project using Spring Boot 2.4.0. 

### Dependencies

To build the project you need both Java 8 (or higher) and Maven 3.2 (or higher) to be installed.

* first check if **OpenJDK** is installed:

```bash
$ java -version

openjdk version "1.8.0_275"
OpenJDK Runtime Environment Corretto-8.275.01.1 (build 1.8.0_275-b01)
OpenJDK 64-Bit Server VM Corretto-8.275.01.1 (build 25.275-b01, mixed mode)
```

* then check if maven is installed:

```bash
$ mvn -version

Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T20:33:14+02:00)
```
### Project useful commands
| Command  | Description |
| ---------------- | ---------------------------------------------------|
| ./mvnw spring-boot:run | Build and run the project. You can test the web application on http://localhost:8080/ |
| ﻿ mvn package	| Runs unit tests and packages all in a jar in the tarjet folder |
| mvn install | Like mvn package but also installs the jar in local Maven repository where it can be accessed by projects that depend on it. |
| mvn install -DskipTests=true	| Like mvn install but skips unit tests. |
| mvn test	| Run all the unit tests. |
| java -jar [jar file]	| If you prefer to execute the jar file you can easily run it by using this. Then you can test the web application on http://localhost:8080/  |
