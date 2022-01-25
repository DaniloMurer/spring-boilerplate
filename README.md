# Spring RESTApi Boilerplate Code

## Description
This repository contains a Maven Project with a Spring REST API which has a role based JWT authentication.
<br>
<br>
The project uses a H2 database with the Spring Data JPA Dependency. The project also has two Roles automatically created:
<br>
- USER
- ADMINISTRATOR

## How to use

To get started you have to clone the repository from GitHub. Then you need to run `mvn install`.
<br>
<br>
After that you can adjust the package names to your needs.
<br>
<br>
<b>Mapped Requests:</b>
- POST /user/signup - Add new User to the database
- POST /login - Get JWT Token from Backend 

## Run as Docker container

First make sure to install docker and docker-compose on the respective OS you're using.

The second step is to build the jar file, this can be done using following command:

```bash
mvn clean install
```

Then you can build and run the container:

```bash
sudo docker-compose up --build
```
## Important

This repository and the code is licensed under the MIT License, thus means you need to mention that the code is from us.

