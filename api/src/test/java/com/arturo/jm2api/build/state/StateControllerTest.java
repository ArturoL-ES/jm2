package com.arturo.jm2api.build.state;

import com.arturo.jm2api.common.Profiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class StateControllerTest {

    @InjectMocks private StateController stateController;
    @Mock private StateService stateService;

    @Test
    public void all() throws Exception {
        List<State> expected = new ArrayList<>(Arrays.asList(new State(), new State(), new State()));
        Mockito.when(stateService.findAll()).thenReturn(expected);

        assertEquals(expected, stateController.all());
    }

}