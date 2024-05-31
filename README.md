# beta

## Keycloak configs

1- set up your keycloak enviornment for me I used docker image
2- to run the docker image use the command:

docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0.4 start-dev

this run keycloak at: localhost:8080
username: admin
password: admin

3- add new realm: "crewper"
4- add new client: "crewper-rest-api"
5- add roles to the "crewper-rest-api" client: "client_admin", "client_user"
6- add roles to the "crewper" realm: "admin", "user"
7- assosiate roles to the realm roles as below:
admin >> client_admin
user  >> client_user

8- add user "crewper-employee" with password "employee" and role mapping to "client_user"
9- add user "crewper-hr" with password "hr" and role mapping to "client_user" and "client_admin"
10- disable authentication required actions

## Generate keycloak tokens using postman
do a POST request on postman
url: http://localhost:8080/realms/crewper/protocol/openid-connect/token
with x-www-form-urlencoded Body...
grant_type: password
client_id: crewper-rest-api
username: crewper-hr	or		crewper-employee
password: hr			or		employee

## Database
create a mySQL database called "crewper" and run the application


##JSONs and Request URLs
http://localhost:8081/api/v1/vacation/request?startDate=2020-03-12&endDate=2020-03-12

{
"id": 1,
"name": "john",
"email": "john@gmail.com",
"phoneNumber": "01101100101",
"totalVacationBalance": 30,
"remainingVacationBalance": 10
}

