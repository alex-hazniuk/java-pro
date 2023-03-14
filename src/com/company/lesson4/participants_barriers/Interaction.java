package com.company.lesson4.participants_barriers;

import com.company.lesson4.participants_barriers.barriers.Barrier;
import com.company.lesson4.participants_barriers.participants.Participant;

public class Interaction {
    private static final String RUNNING_TRACK = "Running track";
    private static final String WALL = "Wall";

    public void interact(Participant[] participants, Barrier[] barriers) {
        if (participants != null && barriers != null
                && participants.length > 0 && barriers.length > 0) {
            for (Participant participant : participants) {
                if (participant == null) {
                    continue;
                }
                for (Barrier barrier : barriers) {
                    if (barrier == null || barrier.getBarrierName() == null) {
                        continue;
                    }
                    String barrierName = barrier.getBarrierName();
                    if (barrierName.equals(RUNNING_TRACK)) {
                        participant.run(barrierName, barrier.getParameter(),
                                barrier.overcome(participant.getMaxRunDistance()));
                        if (!barrier.overcome(participant.getMaxRunDistance())) {
                            break;
                        }
                    }
                    if (barrierName.equals(WALL)) {
                        participant.jump(barrier.getBarrierName(), barrier.getParameter(),
                                barrier.overcome(participant.getMaxJumpHeight()));
                        if (!barrier.overcome(participant.getMaxJumpHeight())) {
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Action impossible! No participants or barriers");
        }
    }
}
