package com.company;

import java.util.HashMap;
import java.util.Map;

import static com.company.utilspkg.Utils.*;
import static com.company.utilspkg.Utils.MIDDLE_VALUE;

public class FakeTriangleRepository {

    Map<Integer , Triangle> triangleMap;

    public FakeTriangleRepository() {
        this.triangleMap = new HashMap<Integer, Triangle>();
        this.triangleMap.put(1, new Triangle(-2, -1, 12));
        this.triangleMap.put(2, new Triangle(1,1,1));
        this.triangleMap.put(3, new Triangle(MIDDLE_VALUE, MIN_VALUE, MIDDLE_VALUE));
        this.triangleMap.put(4, new Triangle(MAX_VALUE - 1, MIDDLE_VALUE, MIDDLE_VALUE + 1));
    }

    public Triangle findTriangleById(int id){
        return triangleMap.get(id);
    }
}
