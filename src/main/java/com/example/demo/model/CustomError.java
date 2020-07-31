package com.example.demo.model;


import lombok.Data;

@Data
public class CustomError {

  String errorCode;
  String field;
  String message;

}
