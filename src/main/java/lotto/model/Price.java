package lotto.model;

public class Price {

	private static final int PRICE_DIVISIBILITY_UNIT = 1000;

	private final int price;

	public Price(int price) {
		this.price = price;
	}

	private void isDivisibleByThousand(int price) {
		if (price % PRICE_DIVISIBILITY_UNIT != 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
		}
	}

	private void isPositive(int price) {
		if (price <= 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 0보다 커야 합니다.");
		}
	}
}
