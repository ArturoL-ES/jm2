package com.arturo.jm2api.build.image;

import com.arturo.jm2api.build.Build;
import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class ImageTest {

    private Image image;
    private Integer idImage = 1;
    private Build build = new Build();
    private String path = "PATH";

    @Before
    public void setUp() throws Exception {
        image = new Image();
        image.setIdImage(idImage);
        image.setBuild(build);
        image.setPath(path);
    }

    @Test
    public void getIdImage() throws Exception {
        assertEquals(idImage, image.getIdImage());
    }

    @Test
    public void setIdImage() throws Exception {
        Integer idImage = 2;
        image.setIdImage(idImage);

        assertEquals(idImage, image.getIdImage());
    }

    @Test
    public void getBuild() throws Exception {
        assertEquals(build, image.getBuild());
    }

    @Test
    public void setBuild() throws Exception {
        Build build = new Build();
        image.setBuild(build);

        assertEquals(build, image.getBuild());
    }

    @Test
    public void getPath() throws Exception {
        assertEquals(path, image.getPath());
    }

    @Test
    public void setPath() throws Exception {
        String path = "NEW_PATH";
        image.setPath(path);

        assertEquals(path, image.getPath());
    }

}