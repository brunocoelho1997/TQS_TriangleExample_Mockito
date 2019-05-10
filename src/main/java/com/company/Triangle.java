package com.company;

import com.company.utilspkg.TriangleType;

import java.util.ArrayList;

public class Triangle {

    private int id;
    private double a,b,c;
    public ArrayList<Triangle> list;
    TriangleService triangleService = new TriangleService();
    TriangleType triangleType;

    public Triangle(){

    }
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(int id, double a, double b, double c) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public int getId() {
        return id;
    }

    public void setA(double a){
        this.a=a;
    }
    public void setB(double b){
        this.b=b;
    }
    public void setC(double c){
        this.c=c;
    }


public boolean getTriangleType(Triangle triangle){

        TriangleType type = triangleService.getTriangleType(triangle);

        System.out.println("Triangle type: " + type);

        return true;
}

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
