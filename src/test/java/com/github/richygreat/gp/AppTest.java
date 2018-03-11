package com.github.richygreat.gp;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.richygreat.gp.config.PairConfig;
import com.github.richygreat.gp.dao.PairConfigRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
	@Autowired
	private PairConfigRepository pairConfigRepository;

	@Test
	public void whenSingleInsert_thenSuccessfulInsertInDB() {
		PairConfig pairConfig = new PairConfig();
		pairConfig.setL1("ICICI");
		pairConfig.setR1("SBI");
		pairConfig.setKey("MODE");
		pairConfig.setValue("NEFT");
		pairConfigRepository.save(pairConfig);

		assertNotNull(pairConfig);
		assertNotEquals(0, pairConfig.getConfigId());
	}
}
