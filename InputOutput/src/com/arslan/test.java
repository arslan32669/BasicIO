package com.arslan;

import java.lang.reflect.Array;

public class test {
    private String some;
    private static int myInt= 3;
    public static void main(String[] args) {
        System.out.println("inside main");



    }

    static {
        System.out.println("static initializer");
        String[] myArgs = {"args"};
        main(myArgs);
    }




}
