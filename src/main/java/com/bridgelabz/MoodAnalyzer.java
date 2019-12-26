package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.exception.MoodAnalyzerException;

public class MoodAnalyzer {
    public String analyse(String message)  {
        try {
            if(message.length() == 0){

                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.Empty_Exception,"please enter message");

            }
            else if (message.contains("sad") || message.contains("Sad")) {

                return "Sad";
            }
            else {
                return "Happy";
            }
        }
        catch (NullPointerException e) {
           throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.Null_Exception,"please enter proper message");
        }
    }


    }

