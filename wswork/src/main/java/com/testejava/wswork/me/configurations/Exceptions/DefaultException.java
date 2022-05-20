package com.testejava.wswork.me.configurations.Exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultException {
    public int code;
    public String message;
    public List<String> errors;
}