package com.interview.utilities;

public class BrowserUtils {


    public static void sleep(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}