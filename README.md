#Spring Server
Database is denormalized and has no duplicates check. All the data is in JSON format.
##Endpoints:

`GET http://localhost:8080/available` - get all non-booked phones

`GET http://localhost:8080/unavailable` - get all booked phones

`GET http://localhost:8080` - get all phones

###POST samples:

Book a phone: phone ID, user name is required 
```shell script
curl -X POST -H "Content-Type: application/json" -d '{"id":"beff85af-488e-4df0-a652-af468f7cbda0", "name":"John"}' --location "http://localhost:8080/book"
```

Unbook (release) a phone: phone ID is required

```shell script

curl -X POST -H "Content-Type: application/json" -d '{"id":"beff85af-488e-4df0-a652-af468f7cbda0"}' --location "http://localhost:8080/unbook"
```

###P.S.
The most interesting part was to plan API.
The most cumbersome part is trying to use Fonoapi while it is unavailable at least 4 months according to their readme.