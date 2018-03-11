package com.github.richygreat.gp.config;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.github.richygreat.gp.exception.AmbiguousPairConfigException;

public class Test {

	public static void main(String[] args) {
		PairConfig config = null;
		List<PairConfig> lsPairConfig = new ArrayList<>();
		config = new PairConfig("ICICI", "CARD", null, "SBI", "CARD", null, "MODE", "IMPS");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", "CARD", null, "SBI", null, null, "MODE", "RTGS");
		lsPairConfig.add(config);
		config = new PairConfig(null, null, null, "SBI", "CARD", null, "MODE", "NEFT");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", "CARD", null, null, null, null, "MODE", "NEFT");
		lsPairConfig.add(config);
		config = new PairConfig("ICICI", null, null, null, null, null, "MODE", "CASH");
		lsPairConfig.add(config);
		config = new PairConfig(null, null, null, null, null, null, "MODE", "NONE");
		lsPairConfig.add(config);

		lsPairConfig.sort(Comparator.comparing(PairConfig::getLevel).reversed());

		PairConfig searchConfig = new PairConfig("ICICI", null, null, null, null, null, "MODE", null);
		int currentLevel = 3;
		PairConfig foundConfig = null;
		for (PairConfig pairConfig : lsPairConfig) {
			System.out.println(pairConfig);
			if (foundConfig != null && currentLevel != pairConfig.getLevel()) {
				break;
			} else if (pairConfig.equals(foundConfig)) {
				throw new AmbiguousPairConfigException("");
			}
		}
	}

}
