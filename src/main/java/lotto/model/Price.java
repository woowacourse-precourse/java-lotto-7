package lotto.model;

import static lotto.message.ErrorMessage.INVALID_PRICE_AMOUNT;
import static lotto.message.ErrorMessage.INVALID_PRICE_VALUE;

import java.util.Map;

public class Price {

	private static final int PRICE_DIVISIBILITY_UNIT = 1000;
	private static final int PERCENTAGE_MULTIPLIER = 100;

	private final int price;

	public Price(int price) {
		validatePrice(price);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public double getProfitRate(Map<Winning, Integer> winningResult) {
		long totalWinningPrize = Winning.getTotalWinningPrize(winningResult);
		return (double)totalWinningPrize / price * PERCENTAGE_MULTIPLIER;
	}

	private void validatePrice(int price) {
		isDivisibleByThousand(price);
		isPositive(price);
	}

	private void isDivisibleByThousand(int price) {
		if (price % PRICE_DIVISIBILITY_UNIT != 0) {
			throw new IllegalArgumentException(INVALID_PRICE_VALUE.getMessage());
		}
	}

	private void isPositive(int price) {
		if (price <= 0) {
			throw new IllegalArgumentException(INVALID_PRICE_AMOUNT.getMessage());
		}
	}
}
