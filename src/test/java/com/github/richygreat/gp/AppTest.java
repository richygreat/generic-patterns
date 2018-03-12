package com.github.richygreat.gp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.richygreat.gp.config.PairConfig;

public class AppTest {
	@Test
	public void whenFirstLevelSearchWithConfigPresent_thenSuccessfulMatch() {

		PairConfig config = null;
		List<PairConfig> lsPairConfig = new ArrayList<>();
		config = new PairConfig("ICICI", "SBI", "CARD", "CARD", null, null, "MODE", "IMPS");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", "SBI", "CARD", null, null, null, "MODE", "RTGS");
		lsPairConfig.add(config);
		config = new PairConfig(null, "SBI", null, "CARD", null, null, "MODE", "NEFT");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", null, "CARD", null, null, null, "MODE", "NEFT");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", "SBI", null, null, null, null, "MODE", "CASH");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", null, null, null, null, null, "MODE", "CASH");
		lsPairConfig.add(config);
		config = new PairConfig(null, null, null, null, null, null, "MODE", "NONE");
		lsPairConfig.add(config);

		PairConfig searchConfig = new PairConfig("ICICI", null, null, null, null, null, "MODE", null);
		PairConfig foundConfig = PairConfig.getConfig(lsPairConfig, searchConfig);

		assertNotNull(foundConfig);
		assertEquals("CASH", foundConfig.getValue());
	}
}
