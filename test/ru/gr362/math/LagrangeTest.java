package ru.gr362.math;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LagrangeTest {
    @Test
    public void testConstructor() {
        HashMap<Double,Double> points = new HashMap<>();
        points.put(0.0, 3.0);
        Lagrange lg = new Lagrange(points);

        double[] parametrs = new double[]{3.0};
        Polynomial pm = new Polynomial(parametrs);

        assertEquals(pm, lg);

        points.clear();
        points.put(-1.0, 0.0);
        points.put(0.0, -1.0);
        points.put(1.0, 0.0);
        lg = new Lagrange(points);
        parametrs = new double[]{-1.0, 0.0, 1.0};
        pm = new Polynomial(parametrs);

        assertEquals(pm, lg);
    }

    @Test
    public void testCreationTime(){
        HashMap<Double, Double> points = new HashMap<>();
        Random r = new Random();
        int pointsCount = 100;
        for (int i = 0; i < pointsCount; i++){
            var x = r.nextDouble() * 20.0 - 10.0;
            var y = r.nextDouble() * 20.0 - 10.0;
            points.put(x, y);
        }
        var startTime = System.nanoTime();
        new Lagrange(points);
        var finishTime = System.nanoTime();
        System.out.println("Время построения полинома Лагранжа: "+ ((finishTime-startTime) / 1_000_000.0));
    }
}