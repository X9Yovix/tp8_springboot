package com.tekup.classdiagram;

import com.tekup.classdiagram.service.PropertyServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {PropertyServiceTest.class})
class ClassdiagramApplicationTests {
	@Test
	void contextLoads() {
	}

}
