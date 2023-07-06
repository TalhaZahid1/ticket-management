package com.personal.practice.exception.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorDetails {

    private String title;
    private int status;
    private String details;
    private long timestamp;
    private String developerMessage;
    private Map<String, List<ValidationError>> validationErrors = new HashMap<>();
}
