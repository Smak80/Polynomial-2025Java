package ru.gr362.math;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Polynomial {
    private final SortedMap<Integer, Double> coef;
    public Polynomial() {
        coef = new TreeMap<Integer, Double>();
        clearIncorrect();
    }
    public Polynomial(@NotNull Map<Integer, Double> coef){
        this.coef = new TreeMap<Integer, Double>(coef);
        clearIncorrect();
    }

    public SortedMap<Integer, Double> getCoef() {
        return new TreeMap<>(coef);
    }

    private void clearIncorrect(){
        for(var k: coef.keySet().toArray()){
            if (coef.get((int)k) == 0.0 || (int)k < 0)
                coef.remove((int)k);
        }
        if (coef.isEmpty()) coef.put(0, 0.0);
    }

    public String toString(String variable){
        var sb= new StringBuilder();
        for(var pow: coef.reversed().keySet()){
            if(coef.get(pow)<0.0) sb.append('-');
            else if (Collections.max(coef.keySet()).intValue() != pow) {
                sb.append('+');
            }
            if(Math.abs(coef.get(pow)) !=1.0 || pow == 0) sb.append(Math.abs(coef.get(pow)));
            if(pow!=0) sb.append(variable);
            if(pow>1) sb.append("^").append(pow);
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return toString("x");
    }

    public double invoke(double x){
        var result = 0.0;
        for(var pow: coef.keySet()){
            result += Math.pow(x, pow) * coef.get(pow);
        }
        return result;
    }

    public Polynomial plus(Polynomial other){
        var sum = new TreeMap<>(coef);
        for (var c: other.coef.keySet()){
            if(sum.containsKey(c)){
                sum.put(c, other.coef.get(c) + sum.get(c));
            } else {
                sum.put(c, other.coef.get(c));
            }
        }
        return new Polynomial(sum);
    }

    public Polynomial times(Polynomial other){
        var prod = new TreeMap<Integer, Double>();
        for (int tc: coef.keySet()){
            for (int oc: other.coef.keySet()){
                if (prod.containsKey(oc+tc)) {
                    prod.put(tc + oc, coef.get(tc) * other.coef.get(oc) + prod.get(tc + oc));
                } else {
                    prod.put(tc + oc, coef.get(tc) * other.coef.get(oc));
                }
            }
        }
        return new Polynomial(prod);
    }

}
