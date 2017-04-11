package com.arturo.jm2api.build;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.common.error.CustomException;

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

    @Test()
    public void saveBuild() throws Exception {
        Build buildWithId = new Build();
        buildWithId.setId(1L);

        Mockito.when(buildDAO.save(build)).thenReturn(build);

        try {

            buildService.saveBuild(buildWithId);
            fail();
        } catch (CustomException ce) {

        }

        assertEquals(build, buildService.saveBuild(build));
    }
    
    @Test(expected = CustomException.class)
    public void deleteBuild() throws Exception {
    	Build buildExists = new Build();
    	Long idExists = 1L;
    	Long idNotExist = 2L;
    	
    	Mockito.when(buildDAO.findOne(idExists)).thenReturn(buildExists);
    	Mockito.when(buildDAO.findOne(idNotExist)).thenReturn(null);
    	
    	buildService.deleteBuild(idExists);
    	buildService.deleteBuild(idNotExist);
    }

}