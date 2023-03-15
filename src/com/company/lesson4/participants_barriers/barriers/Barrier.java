package com.company.lesson4.participants_barriers.barriers;

import com.company.lesson4.participants_barriers.participants.Participant;

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
        return Math.max(parameter, 0);
    }

    public abstract boolean overcome(Participant participant);
}
