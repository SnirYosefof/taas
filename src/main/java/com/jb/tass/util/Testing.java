package com.jb.tass.util;

//Created by sniryosefof on 29 יוני
public class Testing {
    private static int count = 1;

    public static void printCaption(String content){
        System.out.printf("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Test #%d - %s @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n",count++,content);
    }
}

