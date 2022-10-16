# cs-home-assignment
Solving Home assignment

## Requirements
Clone the repo.
For building and running the application you need:

- [JDK 1.11 or grater ]
- [Maven 3]

## Problems 1:
Go to path [ProblemOneApp.java](https://github.com/madhurampotana/cs-home-assignment/blob/main/assignments/src/solve/problem/one/ProblemOneApp.java):
To run:
```shell
$ java ProblemOneApp.java
```
Note: To stop entering the input values press any non integer value.

## Problems 2:
Go to path [ProblemTwoApp.java](https://github.com/madhurampotana/cs-home-assignment/blob/main/assignments/src/solve/problem/two/ProblemTwoApp.java):
To run:
```shell
$ java ProblemTwoApp.java
```
Note: To stop entering the input values press q.

## Problems 3:
Go to [path](https://github.com/madhurampotana/cs-home-assignment/tree/main/assignment) and build using following command.
```shell
$ mvn clean install
```

To run :

```shell
mvn spring-boot:run
```
Or run the generate jar under target

Browser URL
Open your browser at the following URL for Swagger UI:
(http://localhost:8081/swagger-ui/index.html)
There you will find the endpoint.

Go to Postman:
Hit http GET method with url (http://localhost:8081/evaluateExpression)
with JSON body as 
```json
{
  "inputExp": "+ 2 3"
}
```



