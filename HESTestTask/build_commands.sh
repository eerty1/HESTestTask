#!/bin/bash
./mvnw clean package -DskipTests
java -jar /hes-test-task/target/HESTestTask-0.0.1-SNAPSHOT.jar
