package com.tippy.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxTester {
    public static void main(String[] args) {
        /*List<Box> boxes = new  ArrayList();
        boxes.add(new Box1());
        boxes.add(new Box2());*/
        List<Box> boxes = Arrays.asList(
                new Box1(),
                new Box2()
        );
        int length = 11;
        int width = 4;
        int height = 5;
        for (Box box : boxes) {
            if (box.validate(length, width, height)){
                System.out.println(box.name);
            }
        }
    }
}
