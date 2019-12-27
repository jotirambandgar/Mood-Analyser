package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.exception.MoodAnalyzerException;

public class MoodAnalyzer {

    private String message;

   public MoodAnalyzer(String message){
        this.message = message;
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


    }

