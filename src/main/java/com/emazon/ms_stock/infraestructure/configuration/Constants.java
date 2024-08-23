package com.emazon.ms_stock.infraestructure.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ARTICLE_NOT_FOUND_EXCEPTION_MESSAGE = "The article indicated does not exist";
    public static final String BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The brand you want to create already exists";
    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The category you want to create already exists";
    public static final String ARTICLE_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The product you want to create already exists";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "Field %s can not receive negative values";
    public static final String BRAND_NOT_FOUND_EXCEPTION_MESSAGE = "The brand indicated for this product does not exist";
    public static final String CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE = "The category indicated for this product does not exist";
    public static final Long SOLD_OUT_VALUE = 0L;
}
