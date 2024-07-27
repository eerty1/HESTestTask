# HES test task

Bank system 

## Task Requirements

Implement a WEB application "Account management"

The application must support 2 roles.
The **administrator**: block and unblock the account.
The **account holder** : withdraw money from the account and deposit money into the account.

1. The administrator logs into the application and sees a list of all accounts.
It has the ability to block the account or unblock it. He does not perform any more actions.

2. The account holder. Login to the app and only sees his account.
Implement 2 operations: balance fulfillment and money withdrawal. 
If the account is blocked, then no transactions can be performed out.

Number of users: at least 1 administrator and 2 account holders.

## Technology stack

**Spring Boot**,
**Spring Security**,
**Hibernate**,
**PostgreSQL** (preferably in a Docker container)

## Usage

Build and run application:

* git clone HESTestTask

* Navigate your terminal to the root of the project

* Run **docker compose up**

* Open **http://localhost:8080/api/swagger-ui/index.html** to see all the available endpoints and entities

## Peculiarities

The task assumes very strict set of endpoints, that is why data.sql is used to prepopulate database. For the same reason some CRUD operations for the entities are omitted.
