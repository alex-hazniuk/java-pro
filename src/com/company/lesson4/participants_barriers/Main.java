package com.company.lesson4.participants_barriers;

import com.company.lesson4.participants_barriers.barriers.Barrier;
import com.company.lesson4.participants_barriers.barriers.RunningTrack;
import com.company.lesson4.participants_barriers.barriers.Wall;
import com.company.lesson4.participants_barriers.participants.Cat;
import com.company.lesson4.participants_barriers.participants.Human;
import com.company.lesson4.participants_barriers.participants.Participant;
import com.company.lesson4.participants_barriers.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Participant cat = new Cat("Barsik", 50, 2);
        Participant human = new Human("Robert", 500, 1);
        Participant robot = new Robot("Verder", 1000, 5);
        Participant[] participants = {cat, human, robot};

        Barrier runningTrack = new RunningTrack("Running track", 50);
        Barrier wall = new Wall("Wall", 2);
        Barrier[] barriers = {runningTrack, wall};

        interact(participants, barriers);
    }

    public static void interact(Participant[] participants, Barrier[] barriers) {
        if (participants != null && barriers != null
                && participants.length > 0 && barriers.length > 0) {
            for (Participant participant : participants) {
                if (participant == null) {
                    continue;
                }
                for (Barrier barrier : barriers) {
                    if (barrier == null) {
                        continue;
                    }
                    if (!barrier.overcome(participant))
                        break;
                }
            }
        } else {
            System.out.println("Action impossible! No participants or barriers");
        }
    }
}
