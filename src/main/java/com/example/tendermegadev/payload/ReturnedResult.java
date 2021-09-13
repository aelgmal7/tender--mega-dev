package com.example.tendermegadev.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnedResult<T> {

    private HttpStatus status;
    private Boolean succeeded;
    private T result;
}
