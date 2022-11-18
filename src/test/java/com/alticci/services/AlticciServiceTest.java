package com.alticci.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AlticciServiceTest {

	@Autowired
	private AlticciService alticciService;

	@Test
	void testAlticciSequence() {
		assertThat(alticciService.getAlticciSequence(0)).isEqualTo(0);
		assertThat(alticciService.getAlticciSequence(1)).isEqualTo(1);
		assertThat(alticciService.getAlticciSequence(2)).isEqualTo(1);
		assertThat(alticciService.getAlticciSequence(50)).isEqualTo(696081L);
		assertThat(alticciService.getAlticciSequence(100)).isEqualTo(888855064897L);
	}
}
