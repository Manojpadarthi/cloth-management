package com.kanakadurga.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kanakadurga.com.entity.User;
import com.kanakadurga.com.exception.UserNotFoundException;

@ControllerAdvice
public class Handler
{
	@ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<User> handleUserException(UserNotFoundException ex)
  {
	  return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
  }
}
