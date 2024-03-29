package com.example.otusonlinelibrary.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private String message;

    private LocalDateTime dateTime;

    public ErrorDto(String message) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }
}
