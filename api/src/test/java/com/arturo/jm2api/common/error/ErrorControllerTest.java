package com.arturo.jm2api.common.error;

import com.arturo.jm2api.common.Profiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class ErrorControllerTest {

    @InjectMocks private ErrorController errorController;

    @Test
    public void error() throws Exception {
        CustomException ce = new CustomException(HttpStatus.BAD_REQUEST, "ErrorMessage");
        Error error = new Error();
        error.setCode(ce.getStatus().value());
        error.setMessage(ce.getMessage());
        ResponseEntity<Error> expected = new ResponseEntity<>(error, ce.getStatus());

        assertEquals(expected, errorController.error(ce));
        assertEquals(new ResponseEntity<>(Error.errorGeneric(), HttpStatus.INTERNAL_SERVER_ERROR), errorController.error(new RuntimeException()));
    }

}