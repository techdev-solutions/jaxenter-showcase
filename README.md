jaxenter.com Spring example
===========================

This is the second step showing how to set up a base Spring Boot application. It adds Spring Data REST.

Build and run
-------------
Build with

    ./gradlew build
    
and run with

    java -jar ./build/libs/jaxenter-example-1.0.jar
    
Example requests
----------------

    curl localhost:8080
    curl localhost:8080/persons
    curl -X POST -H "Content-Type: application/json" -d "{\"firstName\": \"John\"}" localhost:8080/persons
    curl localhost:8080/persons/search/findByFirstNameLike\?firstName=J%25
    curl -X PUT localhost:8080/persons/1 -d "{\"firstName\": \"Jane\"}" -H "Content-Type: application/json"
    curl -X DELETE localhost:8080/persons/1
