package com.course.me.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    @JsonProperty("status_code")
    private HttpStatus statusCode;
    private String message;
    private T data;

    public ResponseDTO<T> successResponse(T data, String message){
        return new ResponseDTO<>(HttpStatus.OK, message, data);
    }

    public ResponseDTO<T> failureResponse( String message){
        return new ResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR, message, null);
    }
}
