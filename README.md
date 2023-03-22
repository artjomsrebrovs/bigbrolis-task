# BIG BROLIS TASK
## Task details
### Non-functional requirements
- Build a Spring Boot application that reads data from a Kafka topic, processes it, and stores it in a database.
> The application is SpringBoot micro-service that reads messages (weather data) from kafka topic 'weather'.

> The messages are in JSON format, see ./example directory for message sample.

> After message processing, the data is stored in file database H2, database web console is enables and accessible with the following credentials:
> - url: http://localhost:8080/h2/
> - jdbc url: jdbc:h2:file:./weather-data-h2-db
> - user name: admin
> - password: pass 

> Docker file for kafka and micro-service located in ./deploy directory. 