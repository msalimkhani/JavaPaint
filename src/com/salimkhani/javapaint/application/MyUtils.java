package com.salimkhani.javapaint.application;

public class MyUtils {

    public static int getRandomInt(int maxNum) {
        return (int) (Math.random() * maxNum);
    }

    public static Point getRandomPoint(int maxNumX, int maxNumY) {
        return new Point(getRandomInt(maxNumX), getRandomInt(maxNumY));
    }

    public static Point getRandomPoint(int maxNum) {
        return getRandomPoint(maxNum, maxNum);
    }
}
