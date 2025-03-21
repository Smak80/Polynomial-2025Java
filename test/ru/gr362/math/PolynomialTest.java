package ru.gr362.math;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void getCoef() {
        var expected = new TreeMap<Integer, Double>();
        var actual = new TreeMap<Integer, Double>();
        expected.put(0, 0.0);
        var p1 = new Polynomial();
        assertEquals(expected, p1.getCoef());
        expected.clear();

        actual.put(0, -1.0);
        actual.put(1, 2.0);
        expected.put(0, -1.0);
        expected.put(1, 2.0);
        var p2 = new Polynomial(actual);
        assertEquals(expected, p2.getCoef());
        actual.clear();
        expected.clear();

        actual.put(0, 2.0);
        actual.put(1, 0.0);
        actual.put(2, -4.0);

        expected.put(0, 2.0);
        expected.put(2, -4.0);
        var p3 = new Polynomial(actual);
        assertEquals(expected, p3.getCoef());
        actual.clear();
        expected.clear();

        actual.put(0, 2.0);
        actual.put(-1, 4.0);
        actual.put(2, -4.0);

        expected.put(0, 2.0);
        expected.put(2, -4.0);
        var p4 = new Polynomial(actual);
        assertEquals(expected, p4.getCoef());
    }

    @Test
    void testToString() {
        var actual = new TreeMap<Integer, Double>();
        var p1 = new Polynomial();
        assertEquals("0.0", p1.toString());

        actual.put(0, 1.0);
        var p2 = new Polynomial(actual);
        assertEquals("1.0", p2.toString());
        actual.clear();

        actual.put(0, -1.0);
        var p3 = new Polynomial(actual);
        assertEquals("-1.0", p3.toString());
        actual.clear();

        actual.put(0, 2.5);
        actual.put(1, 1.0);
        var p4 = new Polynomial(actual);
        assertEquals("x+2.5", p4.toString());
        actual.clear();

        actual.put(0, -2.5);
        actual.put(1, -1.0);
        var p5 = new Polynomial(actual);
        assertEquals("-x-2.5", p5.toString());
        actual.clear();
    }

    @Test
    void invoke() {
    }

    @Test
    void plus() {
    }
}