package com.arturo.jm2api.build.type;

import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class TypeTest {

    private Type type;
    private Integer idType = 1;
    private String valueType = "VALUE";

    @Before
    public void setUp() throws Exception {
        type = new Type();
        type.setIdType(idType);
        type.setValueType(valueType);
    }

    @Test
    public void getIdType() throws Exception {
        assertEquals(idType, type.getIdType());
    }

    @Test
    public void setIdType() throws Exception {
        Integer idType = 2;
        type.setIdType(idType);

        assertEquals(idType, type.getIdType());
    }

    @Test
    public void getValueType() throws Exception {
        assertEquals(valueType, type.getValueType());
    }

    @Test
    public void setValueType() throws Exception {
        String valueType = "NEW_VALUE";
        type.setValueType(valueType);

        assertEquals(valueType, type.getValueType());
    }

}