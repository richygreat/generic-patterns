package com.github.richygreat.gp.config;

import java.util.Comparator;
import java.util.List;

import com.github.richygreat.gp.exception.AmbiguousPairConfigException;

public class PairConfig {
	private String l1;
	private String r1;
	private String l2;
	private String r2;
	private String l3;
	private String r3;
	private String key;
	private String value;

	public static PairConfig getConfig(List<PairConfig> lsPairConfig, PairConfig searchConfig) {
		PairConfig foundConfig = null;
		if (lsPairConfig != null && !lsPairConfig.isEmpty()) {
			lsPairConfig.sort(Comparator.comparing(PairConfig::getLevel).reversed());
			int currentLevel = lsPairConfig.get(0).getLevel();
			int searchLevel = searchConfig.getLevel();
			for (PairConfig pairConfig : lsPairConfig) {
				if (searchLevel < pairConfig.getLevel()) {
					currentLevel = pairConfig.getLevel();
					continue;
				} else if (foundConfig != null && currentLevel > pairConfig.getLevel()) {
					break;
				} else if (pairConfig.equals(foundConfig)) {
					throw new AmbiguousPairConfigException("");
				} else {
					if (currentLevel > pairConfig.getLevel()) {
						currentLevel = pairConfig.getLevel();
						searchConfig.levelDown(currentLevel);
					}
					if (pairConfig.equals(searchConfig)) {
						foundConfig = pairConfig;
					}
				}
			}
		}
		return foundConfig;
	}

	@Override
	public String toString() {
		return "PairConfig [l1=" + l1 + ", r1=" + r1 + ", l2=" + l2 + ", r2=" + r2 + ", l3=" + l3 + ", r3=" + r3
				+ ", key=" + key + ", value=" + value + "]";
	}

	public PairConfig() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((l1 == null) ? 0 : l1.hashCode());
		result = prime * result + ((l2 == null) ? 0 : l2.hashCode());
		result = prime * result + ((l3 == null) ? 0 : l3.hashCode());
		result = prime * result + ((r1 == null) ? 0 : r1.hashCode());
		result = prime * result + ((r2 == null) ? 0 : r2.hashCode());
		result = prime * result + ((r3 == null) ? 0 : r3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PairConfig other = (PairConfig) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (l1 == null) {
			if (other.l1 != null)
				return false;
		} else if (!l1.equals(other.l1))
			return false;
		if (l2 == null) {
			if (other.l2 != null)
				return false;
		} else if (!l2.equals(other.l2))
			return false;
		if (l3 == null) {
			if (other.l3 != null)
				return false;
		} else if (!l3.equals(other.l3))
			return false;
		if (r1 == null) {
			if (other.r1 != null)
				return false;
		} else if (!r1.equals(other.r1))
			return false;
		if (r2 == null) {
			if (other.r2 != null)
				return false;
		} else if (!r2.equals(other.r2))
			return false;
		if (r3 == null) {
			if (other.r3 != null)
				return false;
		} else if (!r3.equals(other.r3))
			return false;
		return true;
	}

	public PairConfig(String l1, String r1, String l2, String r2, String l3, String r3, String key, String value) {
		this.l1 = l1;
		this.r1 = r1;
		this.l2 = l2;
		this.r2 = r2;
		this.l3 = l3;
		this.r3 = r3;
		this.key = key;
		this.value = value;
	}

	public void levelDown(int newLevel) {
		if (newLevel == 2) {
			l3 = null;
			r3 = null;
		} else if (newLevel == 1) {
			l3 = null;
			r3 = null;
			l2 = null;
			r2 = null;
		} else if (newLevel == 0) {
			l3 = null;
			r3 = null;
			l2 = null;
			r2 = null;
			l1 = null;
			r1 = null;
		}
	}

	public int getLevel() {
		if (l3 != null || r3 != null) {
			return 3;
		} else if (l2 != null || r2 != null) {
			return 2;
		} else if (l1 != null || r1 != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public String getL1() {
		return l1;
	}

	public void setL1(String l1) {
		this.l1 = l1;
	}

	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getL2() {
		return l2;
	}

	public void setL2(String l2) {
		this.l2 = l2;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public String getL3() {
		return l3;
	}

	public void setL3(String l3) {
		this.l3 = l3;
	}

	public String getR3() {
		return r3;
	}

	public void setR3(String r3) {
		this.r3 = r3;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
