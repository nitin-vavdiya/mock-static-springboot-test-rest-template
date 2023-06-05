package com.mock.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {MockApplication.class})
class MockApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		try (MockedStatic<StaticClass> utils = Mockito.mockStatic(StaticClass.class)) {
			utils.when(StaticClass::getMessage).thenReturn("test");
			ResponseEntity<String> response = restTemplate.getForEntity("/test", String.class);
			Assertions.assertNotEquals(StaticClass.MESSAGE, response.getBody());
		}
	}

}
