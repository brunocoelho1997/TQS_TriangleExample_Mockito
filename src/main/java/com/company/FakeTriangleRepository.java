package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.utilspkg.Utils.*;
import static com.company.utilspkg.Utils.MIDDLE_VALUE;

public class FakeTriangleRepository {

    private List<Triangle> triangleList;

    public FakeTriangleRepository() {
        this.triangleList = new ArrayList<Triangle>();
        this.triangleList.add(new Triangle(1, -2, -1, 12));
        this.triangleList.add(new Triangle(2, 1,1,1));
        this.triangleList.add(new Triangle(3, MIDDLE_VALUE, MIN_VALUE, MIDDLE_VALUE));
        this.triangleList.add(new Triangle(4, 2,2,2));
    }

    public Triangle findTriangleById(int id){
        for(Triangle triangle: triangleList)
            if(triangle.getId() == id)
                return triangle;
        return null;
    }

    public boolean create(Triangle triangle) {
        if(triangle.getId() == 0)
            triangle.setId(triangleList.size() + 1);
        this.triangleList.add(triangle);
        return true;
    }
}
