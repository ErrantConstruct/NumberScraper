package com.mattpostema.pindrop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mpostema on 2/13/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No complaints found for area code")
public class AreaCodeNotFoundException extends RuntimeException {

}
