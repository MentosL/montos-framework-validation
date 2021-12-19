package org.montos.statemachine.helper;

import org.montos.statemachine.enums.Events;
import org.montos.statemachine.enums.States;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

/**
 * 构建状态机的步骤
 */
public class MachineFactory {

    public static StateMachine<States, Events> buildMachine() throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();
        builder.configureStates()
                .withStates()
                .initial(States.START)
                .states(EnumSet.allOf(States.class));

        builder.configureTransitions()
                .withExternal()
                .source(States.START).target(States.END)
                .event(Events.START_EVENT)

                .and()
                .withExternal()
                .source(States.END).target(States.START)
                .event(Events.END_EVENT);
        return builder.build();
    }
}
