package com.arturo.jm2api.build.equipment;

import com.arturo.jm2api.common.Profiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class EquipmentServiceImplTest {

    @InjectMocks private EquipmentServiceImpl equipmentService;
    @Mock private EquipmentDAO equipmentDAO;

    @Test
    public void findAll() throws Exception {
        Equipment equipment = new Equipment();
        List<Equipment> equipments = new ArrayList<>(Arrays.asList(equipment));

        Mockito.when(equipmentDAO.findAll()).thenReturn(equipments);

        assertEquals(equipments, equipmentService.findAll());
    }

}