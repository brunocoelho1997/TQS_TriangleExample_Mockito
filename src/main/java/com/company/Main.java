package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //ex 1
        Triangle triangle = new Triangle(100,2,2);
        System.out.println("Triangle type: " + triangle.getType());

        Triangle triangle1 = new Triangle(-2,2,2);
        System.out.println("Triangle1 type: " + triangle1.getType());

        Triangle triangle2 = new Triangle(50,5,5);
        System.out.println("Triangle2 type: " + triangle2.getType());

    }
}
