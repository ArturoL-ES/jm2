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
public class TypeServiceImplTest {

    @InjectMocks private TypeServiceImpl typeService;
    @Mock private TypeDAO typeDAO;

    @Test
    public void findAll() throws Exception {
        List<Type> expected = new ArrayList<>(Arrays.asList(new Type(), new Type()));
        Mockito.when(typeDAO.findAll()).thenReturn(expected);

        assertEquals(expected, typeService.findAll());
    }

}