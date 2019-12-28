package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createModeAnalyser(String message) {
        MoodAnalyzer moodAnalyzer;
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            moodAnalyzer= (MoodAnalyzer) moodConstructor.newInstance(message);
            return moodAnalyzer;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
