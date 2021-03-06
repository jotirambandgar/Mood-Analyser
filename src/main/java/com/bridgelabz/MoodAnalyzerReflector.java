package com.bridgelabz;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerReflector {
//    public static MoodAnalyzer createModeAnalyser(String message) {
//        MoodAnalyzer moodAnalyzer;
//        try {
//            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
//            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
//            moodAnalyzer= (MoodAnalyzer) moodConstructor.newInstance(message);
//            return moodAnalyzer;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static Constructor getConstructor(Class<?>... parameter) {


        try {
           Class moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor constructor = moodAnalyzerClass.getConstructor(parameter);
            return constructor;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getObject(Constructor constructor,String... message) {
        try {
            System.out.println(message.toString());
            return constructor.newInstance(message);
        }catch (Exception e){

            e.printStackTrace();
        }
        return null;
    }


    public static Method getMethod(String methodName) {
        Method method = null;
        try {
            Constructor constructor = getConstructor();
            Object object = getObject(constructor);

            method = object.getClass().getDeclaredMethod(methodName,String.class);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return method;
    }
}
