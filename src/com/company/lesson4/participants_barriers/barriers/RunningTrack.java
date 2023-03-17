package com.company.lesson4.participants_barriers.barriers;

import com.company.lesson4.participants_barriers.participants.Participant;

public class RunningTrack extends Barrier {
    public RunningTrack(String barrierName, int parameter) {
        super(barrierName, parameter);
    }

    @Override
    public boolean overcome(Participant participant) {
        participant.run(getBarrierName(), getParameter());
        return getParameter() <= participant.getMaxRunDistance();
    }
}
