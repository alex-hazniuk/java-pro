package com.company.lesson4.participants_barriers.participants;

public class Human extends Participant {
    public Human(String name, int maxRunLength, int maxJumpHeight) {
        super(name, maxRunLength, maxJumpHeight);
    }

    @Override
    public void run(String barrierName, int parameter) {
        if (getMaxRunDistance() >= parameter) {
            System.out.printf("Human %s overcame %s on a distance %d\n",
                    getName(), barrierName, parameter);
        } else {
            System.out.printf("Human %s didn't overcame %s on a distance %d. Overcame %d\n",
                    getName(), barrierName, parameter, getMaxRunDistance());
        }
    }

    @Override
    public void jump(String barrierName, int parameter) {
        if (getMaxJumpHeight() >= parameter) {
            System.out.printf("Human %s overcame %s with a height %d\n",
                    getName(), barrierName, parameter);
        } else {
            System.out.printf("Human %s didn't overcame %s with a height %d. Overcame %d\n",
                    getName(), barrierName, parameter, getMaxJumpHeight());
        }
    }
}
