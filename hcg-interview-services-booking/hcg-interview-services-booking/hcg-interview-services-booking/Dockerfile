FROM openjdk:17
WORKDIR ./
RUN mkdir ./root/booking-service
COPY ./target/*.jar ./root/booking-service/booking-service.jar
COPY ./wait-for-it.sh ./root/booking-service/wait-for-it.sh
CMD ["./root/booking-service/wait-for-it.sh","mysqldb:4407","--timeout=100","--","java","-Dspring.profiles.active=prod","-jar","./root/booking-service/booking-service.jar"]

