jaxenter.com Spring example
===========================

This is the fourth step showing that adds OAuth Security.

Build and run
-------------
Build with

    ./gradlew build
    
and run with

    java -jar ./build/libs/jaxenter-example-1.0.jar
    java -jar ./authentication-server/build/libs/jaxenter-example-authentication-server-1.0.jar
    
Please be aware that both must be run from within the same directory so they can share the tokens database!
    
Example OAuth Server requests
-----------------------------

The console client can request an access token like this:

    curl curl:password@localhost:8081/oauth/token\?grant_type=client_credentials

The web client has to use this URL. Beware, it will redirect you to github since we don't have a real web client. The token is in the new github URL that you will
be redirected to.

    http://localhost:8081/oauth/authorize?client_id=web&response_type=token

Example requests
-------------
When running the following requests should give you results. Replace $token with the token you have gained!

    curl -H "Authorization: Bearer $token" localhost:8080
    curl -H "Authorization: Bearer $token" localhost:8080/persons
    curl -H "Authorization: Bearer $token" -X POST -H "Content-Type: application/json" -d "{\"firstName\": \"John\"}" localhost:8080/persons
    curl -H "Authorization: Bearer $token" localhost:8080/persons/search/findByFirstNameLike\?firstName=J%25
    curl -H "Authorization: Bearer $token" -X PUT localhost:8080/persons/1 -d "{\"firstName\": \"Jane\"}" -H "Content-Type: application/json"
    curl -H "Authorization: Bearer $token" -X DELETE localhost:8080/persons/1
    
When you use the web client URL the token includes the role and logged in user, so Mary still can't access John's record!
