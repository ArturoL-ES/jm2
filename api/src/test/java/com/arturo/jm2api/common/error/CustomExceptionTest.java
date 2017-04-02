package com.arturo.jm2api.common.error;

import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class CustomExceptionTest {

    private CustomException ce;
    private HttpStatus code = HttpStatus.ACCEPTED;
    private String message = "MESSAGE";

    @Before
    public void setUp() throws Exception {
        ce = new CustomException(code, message);
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals(code, ce.getStatus());
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message, ce.getMessage());
    }

}