package com.fly1tkg.answer;

/**
 * Created by tkg on 2014/10/04.
 */
public class Answer {
    static {
        System.load("/data/data/com.fly1tkg.answer/files/libanswer.so");
    }

    public static native int calculate();
}
