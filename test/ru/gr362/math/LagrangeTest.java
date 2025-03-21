package ru.gr362.math;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LagrangeTest {
    @Test
    public void testConstructor() {
        HashMap<Double,Double> points = new HashMap<Double,Double>();
        points.put(0.0, 3.0);
        Lagrange lg = new Lagrange(points);

        double[] parametrs = new double[]{3.0};
        Polynomial pm = new Polynomial(parametrs);

        assertArrayEquals(pm.coeff, lg.coeff);
    }
}