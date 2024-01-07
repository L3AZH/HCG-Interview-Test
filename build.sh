#!/usr/bin/bash

#Create Dockerfile for service
# shellcheck disable=SC2164

echo "build Inventory Service........"
cd ./hcg-interview-services-inventory/hcg-interview-services-inventory/hcg-interview-services-inventory
chmod +x ./mvnw
./mvnw package -DskipTests
cd ../../../
echo "build Booking Service.........."
cd ./hcg-interview-services-booking/hcg-interview-services-booking/hcg-interview-services-booking
chmod +x ./mvnw
./mvnw package -DskipTests
cd ../../../

docker-compose build

docker-compose up -d
