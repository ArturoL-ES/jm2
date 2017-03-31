package com.arturo.jm2api.build;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.common.error.CustomException;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class BuildServiceImplTest {

    private Build build = new Build();
    private Pageable page = new PageRequest(0, 10);

    @InjectMocks private BuildServiceImpl buildService;
    @Mock private BuildDAO buildDAO;

    @Test
    public void findBuilds() throws Exception {
        Page<Build> expected = new PageImpl<>(Arrays.asList(build));
        Mockito.when(buildDAO.findAll(Example.of(build), page)).thenReturn(expected);

        assertEquals(expected, buildService.findBuilds(build, page));
    }

    @Test
    public void findBuild() throws Exception {
        Mockito.when(buildDAO.findOne(1L)).thenReturn(build);

        assertEquals(build, buildService.findBuild(1L));
    }

    @Test(expected = CustomException.class)
    public void updateBuild() throws Exception {
        Build buildWithId = new Build();
        buildWithId.setId(1L);

        Mockito.when(buildDAO.save(buildWithId)).thenReturn(buildWithId);

        assertEquals(buildWithId, buildService.updateBuild(buildWithId));
        buildService.updateBuild(build);
        fail();
    }

    @Test(expected = CustomException.class)
    public void saveBuild() throws Exception {
        Build buildWithId = new Build();
        build.setId(1L);

        Mockito.when(buildDAO.save(build)).thenReturn(build);

        assertEquals(build, buildService.saveBuild(build));
        buildService.saveBuild(buildWithId);
        fail();
    }

}