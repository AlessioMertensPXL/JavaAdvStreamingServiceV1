package be.pxl.ja.streamingservice.model;

import java.math.BigDecimal;

public enum StreamingPlan {
	BASIC(1, new BigDecimal(7.99D)),
	STANDAARD(2, new BigDecimal(11.99D)),
	PREMIUM(4, new BigDecimal(15.99D));

	public int getNumberOfProfiles() {
		return numberOfProfiles;
	}

	public BigDecimal getPrice() {
		return price;
	}

	private int numberOfProfiles;
	private BigDecimal price;

	StreamingPlan(int numberOfProfiles, BigDecimal price) {
		this.numberOfProfiles = numberOfProfiles;
		this.price = price;
	}
}