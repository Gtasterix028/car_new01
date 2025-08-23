package com.spring.jwt.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ResponseDto {
    public String status;
    public String message;
    private Integer premiumCarId;

    public ResponseDto(String status, String message) {
        this.status=status;
        this.message=message;
    }
    public ResponseDto() {

    }

//    public ResponseDto(String status, String message, String details) {
//        this.status = status;
//        this.message = message;
//        this.details = details;
//    }

    public ResponseDto(String status, String message, Integer premiumCarId) {
        this.status=status;
        this.message=message;
        this.premiumCarId = premiumCarId;
    }
}
