package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private int code;
    private boolean flag;
    private String errorMessage;
}
