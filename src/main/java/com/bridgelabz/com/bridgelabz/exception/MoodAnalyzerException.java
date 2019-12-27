package com.bridgelabz.com.bridgelabz.exception;

public class MoodAnalyzerException extends RuntimeException {
    public enum ExceptionType {NULL_EXCEPTION,EMPTY_EXCEPTION};
    public ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message) {
        super(message) ;
        this.type = type ;
    }
}
