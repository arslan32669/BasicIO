package com.arslan;

public class Test {
    private String something;

    public Test() {
        this.something = "something";
//        System.out.println("class instance initialized");
    }

    static {
        System.out.println("Static block is initialized");
    }

    public void test() {
        System.out.println("Constructor");
    }
}
