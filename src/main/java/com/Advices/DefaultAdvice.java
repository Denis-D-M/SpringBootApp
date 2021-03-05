package com.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class DefaultAdvice extends DefaultHandlerExceptionResolver {
    @Override
    protected ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        return super.handleMethodArgumentNotValidException(ex, request, response, handler);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<Response> doHandle(IndexOutOfBoundsException e){
        Response response = new Response(e.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
