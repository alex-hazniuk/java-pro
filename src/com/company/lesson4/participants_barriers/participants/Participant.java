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

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void run(String barrierName, int parameter, boolean overcome) {
        if (parameter >= 0 && maxRunDistance >= 0) {
            if (overcome) {
                System.out.printf("Participant %s overcame %s on a distance %d\n",
                        name, barrierName, parameter);
            } else {
                System.out.printf("Participant %s did`t overcame %s on a distance %d." +
                                " Overcame %d\n",
                        name, barrierName, parameter, maxRunDistance);
            }
        } else {
            System.out.printf("Distance for %s can't be negative. Change parameter!\n", name);
        }
    }

    public void jump(String barrierName, int parameter, boolean overcome) {
        if (parameter >= 0 && maxJumpHeight >= 0) {
            if (overcome) {
                System.out.printf("Participant %s overcame %s with a height %d\n",
                        name, barrierName, parameter);
            } else {
                System.out.printf("Participant %s did`t overcame %s with a height %d." +
                                " Overcame %d\n",
                        name, barrierName, parameter, maxJumpHeight);
            }
        } else {
            System.out.printf("Height for %s can't be negative. Change parameter!\n", name);
        }
    }
}
