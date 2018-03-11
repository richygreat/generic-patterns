package com.github.richygreat.gp.config;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PairConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long configId;
	private String l1;
	private String r1;
	private String l2;
	private String r2;
	private String l3;
	private String r3;
	private String key;
	private String value;

	@Override
	public String toString() {
		return "PairConfig [l1=" + l1 + ", r1=" + r1 + ", l2=" + l2 + ", r2=" + r2 + ", l3=" + l3 + ", r3=" + r3
				+ ", key=" + key + ", value=" + value + "]";
	}

	public PairConfig() {
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

	public long getConfigId() {
		return configId;
	}

	public void setConfigId(long configId) {
		this.configId = configId;
	}

}
