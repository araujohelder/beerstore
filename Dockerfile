FROM openjdk:8u181-jdk-alpine3.8

LABEL maintainer="heldersilvaaraujo@gmail.com"

ENV LANG C.UTF-8

RUN apk add --update bash

ADD build/libs/*.jar /app/app.jar

CMD java -jar /app/app.jar '--spring.datasource.url=jdbc:postgresql://beerdb:5432/beerstore'
                            