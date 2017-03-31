package com.arturo.jm2api.build.equipment;

import com.arturo.jm2api.common.Profiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class EquipmentControllerTest {

    @InjectMocks private EquipmentController equipmentController;
    @Mock private EquipmentService equipmentService;

    @Test
    public void all() throws Exception {
        Equipment equipment = new Equipment();
        List<Equipment> equipments = new ArrayList<>(Arrays.asList(equipment));

        Mockito.when(equipmentService.findAll()).thenReturn(equipments);

        assertEquals(equipments, equipmentController.all());
    }

}