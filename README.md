# Account Manager

RESTful API for money transfers between accounts.

### Requirements:
Java 8

### Start
To start application use command:
```sh
mvn spring-boot:run
```


### 

Application starts on localhost port 8081. An H2 in-memory database initialized with account data.

- http://localhost:8081/v1

### Available Services

| HTTP METHOD | PATH | USAGE |
| -----------| ------ | ------ |
| GET | /account/{accountId} | get account by accountId |
| POST | /transfer | perform transfer between two accounts | 

### Http Status
- 200 OK: The request has succeeded
- 400 Bad Request: The request could not be understood by the server
- 404 Not Found: The requested resource cannot be found
- 500 Internal Server Error: The server encountered an unexpected condition

### Sample Request and Response

##### Get account by accountId:

- GET http://localhost:8081/v1/account/88888888

Response body:
```sh
{
    "id": "88888888",
    "balance": 1000000.000000,
    "currency": "HKD"
}
```

##### Transfer between two accounts:

- POST http://localhost:8081/v1/transfer

Request body:
```sh
{
    "accountFromId" : "12345678",
    "accountToId": "88888888",
    "amount":100.999999,
    "currency": "HKD"
}
```

Response body (Return from account information):
```sh
{
"id": "12345678",
"balance": 99899.000001,
"currency": "HKD"
}
```