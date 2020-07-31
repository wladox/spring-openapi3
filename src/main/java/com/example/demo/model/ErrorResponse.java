package com.example.demo.model;

import java.util.List;
import lombok.Data;

@Data
public class ErrorResponse {

  List<CustomError> errors;

}
