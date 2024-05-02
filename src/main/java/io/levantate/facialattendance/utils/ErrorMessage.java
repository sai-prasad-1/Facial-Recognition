package io.levantate.facialattendance.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
public class ErrorMessage {
   
    private String message;
    private String details;
}
