package com.arturo.jm2api.build;

import com.arturo.jm2api.build.equipment.Equipment;
import com.arturo.jm2api.build.feature.Feature;
import com.arturo.jm2api.build.image.Image;
import com.arturo.jm2api.build.state.State;
import com.arturo.jm2api.build.type.Type;
import com.arturo.jm2api.common.Profiles;
import org.junit.After;
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
public class BuildTest {

    private Long id = 1L;
    private Float price = 10f;
    private String currency = "TEST_CURRENCY";
    private String descripcion = "TEST_DESCRIPTION";
    private State state;
    private Type type;
    private String ccaa = "TEST_CCAA";
    private String city = "TEST_CITY";
    private Set<Feature> features = new HashSet<>();
    private Set<Equipment> equipments = new HashSet<>();
    private Set<Image> images = new HashSet<>();
    private String identifier = "TEST_IDENTIFIER";

    private Build build;

    @Before
    public void setUp() throws Exception {
        build = new Build();

        build.setId(id);
        build.setPrice(price);
        build.setCurrency(currency);
        build.setDescription(descripcion);

        state = new State();
        state.setId(1);
        state.setValue("TEST_STATE");
        build.setState(state);

        type = new Type();
        type.setId(1);
        type.setValue("TEST_TYPE");
        build.setType(type);

        build.setCcaa(ccaa);
        build.setCity(city);

        Feature feature = new Feature();
        features.add(feature);
        build.setFeatures(features);

        Equipment equipment = new Equipment();
        equipments.add(equipment);
        build.setEquipments(equipments);

        Image image = new Image();
        images.add(image);
        build.setImages(images);

        build.setIdentifier(identifier);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getId() throws Exception {
        assertEquals(id, build.getId());
    }

    @Test
    public void setId() throws Exception {
        Long id = 10L;
        build.setId(id);

        assertEquals(id, build.getId());
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals(price, build.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        Float price = 100f;
        build.setPrice(price);

        assertEquals(price, build.getPrice());
    }

    @Test
    public void getCurrency() throws Exception {
        assertEquals(currency, build.getCurrency());
    }

    @Test
    public void setCurrency() throws Exception {
        String currency = "USD";
        build.setCurrency(currency);

        assertEquals(currency, build.getCurrency());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(descripcion, build.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        String description = "NEW_DESCRIPTION";
        build.setDescription(description);

        assertEquals(description, build.getDescription());
    }

    @Test
    public void getState() throws Exception {
        assertEquals(state, build.getState());
    }

    @Test
    public void setState() throws Exception {
        State state = new State();
        state.setId(2);
        state.setValue("NEW_STATE");
        build.setState(state);

        assertEquals(state, build.getState());
    }

    @Test
    public void getType() throws Exception {
        assertEquals(type, build.getType());
    }

    @Test
    public void setType() throws Exception {
        Type type = new Type();
        type.setId(2);
        type.setValue("NEW_TYPE");
        build.setType(type);

        assertEquals(type, build.getType());
    }

    @Test
    public void getCcaa() throws Exception {
        assertEquals(ccaa, build.getCcaa());
    }

    @Test
    public void setCcaa() throws Exception {
        String ccaa = "NEW_CCAA";
        build.setCcaa(ccaa);

        assertEquals(ccaa, build.getCcaa());
    }

    @Test
    public void getCity() throws Exception {
        assertEquals(city, build.getCity());
    }

    @Test
    public void setCity() throws Exception {
        String city = "NEW_CITY";
        build.setCity(city);

        assertEquals(city, build.getCity());
    }

    @Test
    public void getFeatures() throws Exception {
        assertEquals(features, build.getFeatures());
    }

    @Test
    public void setFeatures() throws Exception {
        Set<Feature> features = new HashSet<>();
        features.add(new Feature());
        features.add(new Feature());
        features.add(new Feature());
        build.setFeatures(features);

        assertEquals(features, build.getFeatures());
    }

    @Test
    public void getEquipments() throws Exception {
        assertEquals(equipments, build.getEquipments());
    }

    @Test
    public void setEquipments() throws Exception {
        Set<Equipment> equipments = new HashSet<>();
        equipments.add(new Equipment());
        equipments.add(new Equipment());
        equipments.add(new Equipment());
        build.setEquipments(equipments);

        assertEquals(equipments, build.getEquipments());
    }

    @Test
    public void getImages() throws Exception {
        assertEquals(images, build.getImages());
    }

    @Test
    public void setImages() throws Exception {
        Set<Image> images = new HashSet<>();
        images.add(new Image());
        images.add(new Image());
        images.add(new Image());
        build.setImages(images);

        assertEquals(images, build.getImages());
    }

    @Test
    public void getIdentifier() throws Exception {
        assertEquals(identifier, build.getIdentifier());
    }

    @Test
    public void setIdentifier() throws Exception {
        String identifier = "NEW_IDENTIFIER";
        build.setIdentifier(identifier);

        assertEquals(identifier, build.getIdentifier());
    }

}