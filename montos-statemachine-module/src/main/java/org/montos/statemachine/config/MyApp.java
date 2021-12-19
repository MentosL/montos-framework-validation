package org.montos.statemachine.config;

import org.montos.statemachine.enums.Events;
import org.montos.statemachine.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

public class MyApp {


    @Autowired
    StateMachine<States, Events> stateMachine;

    void doSignals() {
        stateMachine.start();
        stateMachine.sendEvent(Events.START_EVENT);
        stateMachine.sendEvent(Events.END_EVENT);
    }
}
