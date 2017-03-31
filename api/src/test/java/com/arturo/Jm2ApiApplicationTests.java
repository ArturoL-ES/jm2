package com.arturo;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.config.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class Jm2ApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
