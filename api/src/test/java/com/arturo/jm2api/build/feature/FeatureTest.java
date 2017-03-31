package com.arturo.jm2api.build.feature;

import com.arturo.jm2api.build.Build;
import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class FeatureTest {

    private Feature feature;
    private Integer idFeature = 1;
    private String valueFeture = "VALUE";
    private Set<Build> builds = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        feature = new Feature();

        feature.setIdFeature(idFeature);
        feature.setValueFeature(valueFeture);

        builds.add(new Build());
        feature.setBuilds(builds);
    }

    @Test
    public void getIdFeature() throws Exception {
        assertEquals(idFeature, feature.getIdFeature());
    }

    @Test
    public void setIdFeature() throws Exception {
        Integer idFeature = 2;
        feature.setIdFeature(idFeature);

        assertEquals(idFeature, feature.getIdFeature());
    }

    @Test
    public void getValueFeature() throws Exception {
        assertEquals(valueFeture, feature.getValueFeature());
    }

    @Test
    public void setValueFeature() throws Exception {
        String valueFeature = "NEW_VALUE";
        feature.setValueFeature(valueFeature);

        assertEquals(valueFeature, feature.getValueFeature());
    }

    @Test
    public void getBuilds() throws Exception {
        assertEquals(builds, feature.getBuilds());
    }

    @Test
    public void setBuilds() throws Exception {
        Set<Build> builds = new HashSet<>(Arrays.asList(new Build(), new Build(), new Build()));
        feature.setBuilds(builds);

        assertEquals(builds, feature.getBuilds());
    }

}