package com.emazon.ms_stock.infraestructure.configuration.exceptionhandlre;

import com.emazon.ms_stock.infraestructure.configuration.Constants;
import com.emazon.ms_stock.infraestructure.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(ArticleAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleArticleAlreadyExistException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.ARTICLE_ALREADY_EXISTS_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleArticleNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
           Constants.ARTICLE_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(BrandAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleBrandAlreadyExistException(){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBrandNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.BRAND_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNoDataFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }


}
