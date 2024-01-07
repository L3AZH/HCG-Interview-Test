# HCG INTERVIEW TEST

## System require

Java: 17  
MYSQL: 8+  
ActiveMQ: latest
Docker: latest  
Git: latest

## File and document

1. ERD ( `*.drawio` file, `*.pdf` file)
2. MYSQL Workbench( `*.mwb`)

## Build and run with Docker

Run the `build.sh` script with `gitbash` or `WSL system`( your choice)

```bash
./build.sh
```

After all the container are online and switch to running status, manually import the `InsertData.sql` script( you can using MySQL Workbench to connect to server and run the script or using MySQL Client to import the script)

**Note**

The project are setup with 2 application profile (`application-local.yml` and `application-prod.yml`)  
Build and run with Docker will run the `application-prod.yml`

You can still run with Docker successfully without any error but when processing to the API `/booking` there is a minor issue when build with Docker, the `java` file: `hcg-interview-services-booking\hcg-interview-services-booking\hcg-interview-services-booking\src\main\java\com\l3azh\hcginterviewservicesbooking\hcginterviewservicesbooking\service\external\InventoryService.java` in `hcg-interview-service-booking` is using the `localhost` path to call `RestTemplate` and it's wrong behavior in Docker.

```java
@Repository
public interface InventoryService {
    String BASE_URL = "http://localhost:9090/v1";
    interface GetRoomRateAndAvailability {
        HttpMethod METHOD = HttpMethod.GET;
        String URL = "/getRoomRateAndAvailability";
        BaseResponseDto<List<RoomRateAndAvailabilityDto>> getRoomRateAndRoomAvailability(String startDate, String endDate);
    }

}
```

## Build and run in local

**Requirement**

- Install MYSQL 8+ and manually import those sql script: `CreateDatabase.sql` , `CreateTable.sql` , `InsertData.sql`

- Start the ActiveMQ service in: `apache-activemq-6.0.1-bin\apache-activemq-6.0.1\bin\win64` (Windown: locate to this folder and using cmd run `activemq.bat`. For other OS: you should download on the homepage of activemq and run)

- Manually starting the project `booking` and `inventory`
