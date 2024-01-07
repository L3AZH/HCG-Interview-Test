package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.service.external;

import com.google.gson.Gson;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.RoomRateAndAvailabilityDto;
import com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking.dto.base.BaseResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService.GetRoomRateAndAvailability {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;

    @Override
    public BaseResponseDto<List<RoomRateAndAvailabilityDto>> getRoomRateAndRoomAvailability(String startDate, String endDate) {
        String requestUrl = String.format("%s%s",
                InventoryService.BASE_URL,
                InventoryService.GetRoomRateAndAvailability.URL);
        String uriBuilder = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam("startDate", startDate)
                .queryParam("endDate", endDate).encode().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> headerEntity = new HttpEntity<>(headers);
        ResponseEntity<BaseResponseDto> response =
                restTemplate.exchange(
                        uriBuilder,
                        InventoryService.GetRoomRateAndAvailability.METHOD,
                        headerEntity, BaseResponseDto.class);

        if (HttpStatus.OK.equals(response.getStatusCode()) && response.getBody() != null) {
            String data = gson.toJson(response.getBody().getData());
            Type type = new TypeToken<List<RoomRateAndAvailabilityDto>>(){}.getType();
            List<RoomRateAndAvailabilityDto> result = gson.fromJson(data, type);
            return BaseResponseDto.<List<RoomRateAndAvailabilityDto>>builder()
                    .code(HttpStatus.OK.value())
                    .flag(true)
                    .data(result).build();
        }
        return BaseResponseDto.<List<RoomRateAndAvailabilityDto>>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .flag(false)
                .data(Collections.emptyList()).build();

    }
}
