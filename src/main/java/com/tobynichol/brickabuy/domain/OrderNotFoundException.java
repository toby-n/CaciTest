package com.tobynichol.brickabuy.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    //Set custom error handling. This needs extra work to add custom message for 404.

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String exception){
        super(exception);
    }

}
