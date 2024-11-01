package lotto.model;

public class Price {

	private final int price;

	public Price(int price) {
		this.price = price;
	}

	private void isDivisibleByThousand(int price) {
		if (price % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
		}
	}
}
