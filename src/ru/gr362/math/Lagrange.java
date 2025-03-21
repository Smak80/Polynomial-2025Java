package ru.gr362.math;

import java.util.HashMap;
import java.util.Map;

public class Lagrange extends Polynomial{
    private final HashMap<Double, Double> points;

    public Lagrange(Map<Double, Double> points){
        this.points = new HashMap<>(points);
        create();
    }

    private void create(){
        var p = new Polynomial();
        for (var x: points.keySet()){
            p = p.plus(fundamental(x).times(points.get(x)));
        }
        coef.clear();
        coef.putAll(p.coef);
    }

    private Polynomial fundamental(double x){
        var p = new Polynomial(new double[]{1.0});
        for (var cx: points.keySet()){
            if (x == cx) continue;
            try {
                p = p.times(new Polynomial(new double[]{-cx, 1.0}).div(x - cx));
            } catch (Exception e){}
        }
        return p;
    }

}
