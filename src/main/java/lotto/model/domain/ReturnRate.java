package lotto.model.domain;

public class ReturnRate {
	private final int totalSpent;
	private final int totalPrize;

	public ReturnRate(int totalSpent, int totalPrize) {
		this.totalSpent = totalSpent;
		this.totalPrize = totalPrize;
	}

	public double calculate() {
		double rate = (double)totalPrize / totalSpent;

		return roundToOneDecimalPlace(rate * 100);
	}

	private double roundToOneDecimalPlace(double value) {
		return Math.round(value * 10) / 10.0;
	}
}
