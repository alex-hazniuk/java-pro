package com.company.lesson4.participants_barriers.barriers;

public abstract class Barrier {
    private String barrierName;
    private int parameter;

    public Barrier(String barrierName, int parameter) {
        this.barrierName = barrierName;
        this.parameter = parameter;
    }

    public String getBarrierName() {
        return barrierName;
    }

    public int getParameter() {
        return parameter;
    }

    public boolean overcome(int maxValue) {
        return parameter <= maxValue;
    }
}
