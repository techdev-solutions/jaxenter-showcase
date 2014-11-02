jaxenter.com Spring example
===========================

This is the third step showing how to set up a base Spring Boot application. This steps adds security to POST, PUT and DELETE requests.

Build and run
-------------
Build with

    ./gradlew build
    
and run with

    java -jar ./build/libs/jaxenter-example-1.0.jar
    
Example requests
-------------
When running the following requests should give you results:

    curl John:password@localhost:8080
    curl John:password@localhost:8080/persons
    curl -X POST -H "Content-Type: application/json" -d "{\"firstName\": \"John\"}" John:password@localhost:8080/persons
    curl John:password@localhost:8080/persons/search/findByFirstNameLike\?firstName=J%25
    curl -X PUT John:password@localhost:8080/persons/1 -d "{\"firstName\": \"Jane\"}" -H "Content-Type: application/json"
    curl -X DELETE John:password@localhost:8080/persons/1
    
The other username is Mary and has less rights than John.