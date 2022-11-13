package com.app.ecommerce.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ErrorRes implements Serializable {
    private int code;
    private String reason;
    private String path;
}