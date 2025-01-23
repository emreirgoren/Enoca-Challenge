package com.enoca_challenge_5.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResponse{

    private String status;
    private String message;
    private HttpStatus httpStatus;

    public static GenericResponse failed(String message){
        return GenericResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .status(GenericResponseConstants.FAILED)
                .message(message)
                .build();
    }

}
