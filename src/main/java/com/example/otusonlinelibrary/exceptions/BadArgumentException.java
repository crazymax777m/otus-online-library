package com.example.otusonlinelibrary.exceptions;

public class BadArgumentException extends IllegalArgumentException {
    public BadArgumentException(String message) {
        super(message);
    }
}
