# spring-kinesis-poc
1. Start the application in intellij/eclipse
2. Try stopping the application in intellij, watch out for error stating "Error unlocking dynamo db table"
3. If there is no error, repeat steps 1 and 2 several times.
4. Once the error appears, then try starting the application. Notice that the consumer will never consume messages.
5. If the consumer group is changed, then application starts consuming messages.

To Push Message send post request with body

Post: localhost:8081/send
