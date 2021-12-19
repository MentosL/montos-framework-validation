package org.montos.statemachine.controller;

import org.montos.statemachine.enums.Events;
import org.montos.statemachine.enums.States;
import org.montos.statemachine.helper.MachineFactory;
import org.springframework.statemachine.StateMachine;

public class MachineStart {

    public static void main(String[] args) throws Exception {
        StateMachine<States, Events> stateMachine = MachineFactory.buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(Events.START_EVENT);
        stateMachine.sendEvent(Events.END_EVENT);
;    }
}
