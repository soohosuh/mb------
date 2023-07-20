package org.dongju.mb;

import org.dongju.mb.mappers.TimeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MbApplicationTests {

	@Autowired
	TimeMapper timeMapper;

	@Test
	public void testTime() {

		log.info("---------------------");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());

	}

	@Test
	void contextLoads() {
		log.info("Context load...");
	}

}
