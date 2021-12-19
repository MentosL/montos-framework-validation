package org.montos.statemachine.config;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class MyBean {

    @OnTransition(target = "START")
    void toState1() {
    }

    @OnTransition(target = "END")
    void toState2() {
    }
}