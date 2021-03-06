package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.exception.MoodAnalyzerException;

import java.util.Objects;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message){
        this.message = message;
    }
    public String analyser(String message) {
        this.message=message;
        return analyse();

    }

    public String analyse()  {
        try {
            if(message.length() == 0) {

                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.EMPTY_EXCEPTION,"please enter message");

            }
            else if (message.contains("sad") || message.contains("Sad")) {

                return "Sad";
            }
            else {
                return "Happy";
            }
        }
        catch (NullPointerException e) {
           throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL_EXCEPTION,"please enter proper message");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}

