package com.arturo.jm2api.build.type;

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
public class TypeControllerTest {

    @InjectMocks private TypeController typeController;
    @Mock private TypeService typeService;

    @Test
    public void all() throws Exception {
        List<Type> expected = new ArrayList<>(Arrays.asList(new Type(), new Type(), new Type()));
        Mockito.when(typeService.findAll()).thenReturn(expected);

        assertEquals(expected, typeController.all());
    }

}