package com.arturo.jm2api.build.equipment;

import com.arturo.jm2api.build.Build;
import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class EquipmentTest {

    private Equipment equipment;
    private Integer idEquipment = 1;
    private String valueEquipment = "VALUE";
    private Set<Build> builds = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        equipment = new Equipment();

        equipment.setIdEquipment(idEquipment);
        equipment.setValueEquiment(valueEquipment);

        Build build = new Build();
        builds.add(build);
        equipment.setBuilds(builds);
    }

    @Test
    public void getIdEquipment() throws Exception {
        assertEquals(idEquipment, equipment.getIdEquipment());
    }

    @Test
    public void setIdEquipment() throws Exception {
        Integer id = 2;
        equipment.setIdEquipment(id);

        assertEquals(id, equipment.getIdEquipment());
    }

    @Test
    public void getValueEquiment() throws Exception {
        assertEquals(valueEquipment, equipment.getValueEquiment());
    }

    @Test
    public void setValueEquiment() throws Exception {
        String valueEquiment = "NEW_VALUE";
        equipment.setValueEquiment(valueEquiment);

        assertEquals(valueEquiment, equipment.getValueEquiment());
    }

    @Test
    public void getBuilds() throws Exception {
        assertEquals(builds, equipment.getBuilds());
    }

    @Test
    public void setBuilds() throws Exception {
        Set<Build> builds = new HashSet<>();
        builds.add(new Build());
        builds.add(new Build());
        builds.add(new Build());
        equipment.setBuilds(builds);

        assertEquals(builds, equipment.getBuilds());
    }

}