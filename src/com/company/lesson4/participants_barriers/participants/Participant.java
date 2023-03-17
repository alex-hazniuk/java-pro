package com.company.lesson4.participants_barriers.participants;

public abstract class Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Participant(String name, int maxRunLength, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxRunDistance() {
        return Math.max(maxRunDistance, 0);
    }

    public int getMaxJumpHeight() {
        return Math.max(maxJumpHeight, 0);
    }

    public abstract void run(String barrierName, int parameter);

    public abstract void jump(String barrierName, int parameter);
}
