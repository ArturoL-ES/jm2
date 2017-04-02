package com.arturo.jm2api.build.state;

import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class StateTest {

    private State state;
    private Integer idState = 1;
    private String valueState = "STATE";

    @Before
    public void setUp() throws Exception {
        state = new State();
        state.setIdState(idState);
        state.setValueState(valueState);
    }

    @Test
    public void getIdState() throws Exception {
        assertEquals(idState, state.getIdState());
    }

    @Test
    public void setIdState() throws Exception {
        Integer idState = 2;
        state.setIdState(idState);

        assertEquals(idState, state.getIdState());
    }

    @Test
    public void getValueState() throws Exception {
        assertEquals(valueState, state.getValueState());
    }

    @Test
    public void setValueState() throws Exception {
        String valueState = "NEW_STATE";
        state.setValueState(valueState);

        assertEquals(valueState, state.getValueState());
    }

}