package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    static int add=0;
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.forEach((new Demo())::inputByDoubleColon);
        System.out.println("addition after double colon : "+add);
    }

    public void inputByDoubleColon(int num){
        add+=num;

    }
}
