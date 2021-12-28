package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private Boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }
}
