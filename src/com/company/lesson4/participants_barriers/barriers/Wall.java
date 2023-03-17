package com.company.lesson4.participants_barriers.barriers;

import com.company.lesson4.participants_barriers.participants.Participant;

public class Wall extends Barrier {
    public Wall(String barrierName, int parameter) {
        super(barrierName, parameter);
    }

    @Override
    public boolean overcome(Participant participant) {
        participant.jump(getBarrierName(), getParameter());
        return getParameter() <= participant.getMaxJumpHeight();
    }
}
