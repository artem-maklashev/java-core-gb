package ru.study.lesson4.exeptions;

public class MyArrayException extends Exception{
    private final String message;

    public MyArrayException(String message) {
        this.message = message;
    }

    public String getMessage(String message){
        return message;
    }
}
