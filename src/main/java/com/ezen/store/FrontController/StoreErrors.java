package com.ezen.store.FrontController;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class StoreErrors {
    public static Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<String, String>();
        for(FieldError error : errors.getFieldErrors()){
            String validKeyNAme = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyNAme, error.getDefaultMessage());
        }
        return validatorResult;
    }
}
