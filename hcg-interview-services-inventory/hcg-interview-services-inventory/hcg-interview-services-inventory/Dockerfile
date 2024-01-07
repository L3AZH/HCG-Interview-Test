FROM openjdk:17
WORKDIR ./
RUN mkdir ./root/inventory-service
COPY ./target/*.jar ./root/inventory-service/inventory-service.jar
COPY ./wait-for-it.sh ./root/inventory-service/wait-for-it.sh
CMD ["./root/inventory-service/wait-for-it.sh","mysqldb:4407","--timeout=100","--","java","-Dspring.profiles.active=prod","-jar","./root/inventory-service/inventory-service.jar"]