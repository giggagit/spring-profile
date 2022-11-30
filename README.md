# Welcome to Spring Profile demo!
This demo contain how spring profile work and how to config log4j2

## Run the Application
To run the application, run the following command in a terminal window (in the complete) directory:

**Profile: dev**

```python
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

**Profile: prod**

```python
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

## Build jar file

To build jar file with active-profile use -P xxx (xxx = profile name)

```python
mvn clean package -P prod
```

you can also build file without -P argument then maven will build file with default profile

## Run jar file
To run the jar file, run the following command in a terminal window (in the complete) directory:

**Profile: dev**

```python
java -Dspring.profiles.active=dev -jar target/spring-profile-0.0.1-SNAPSHOT.jar
```

**Profile: prod**

```python
java -Dspring.profiles.active=prod -jar target/spring-profile-0.0.1-SNAPSHOT.jar
```

if you not provide JVM arguments then default profile will active

## Test

```python
curl -X GET localhost:8090/msg
curl -X GET localhost:8090/service?testParam=paramValue
```