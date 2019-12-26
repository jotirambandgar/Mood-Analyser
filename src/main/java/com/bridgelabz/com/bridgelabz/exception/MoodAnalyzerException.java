package com.bridgelabz.com.bridgelabz.exception;

public class MoodAnalyzerException extends RuntimeException {
    public enum ExceptionType {Null_Exception,Empty_Exception};
    ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message) {
        super(message) ;
        this.type = type ;
    }
}
