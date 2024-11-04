package lotto.model;

import static lotto.message.ErrorMessage.INVALID_PRICE_AMOUNT;
import static lotto.message.ErrorMessage.INVALID_PRICE_VALUE;

import java.text.DecimalFormat;
import java.util.Map;

public class Price {

	private static final int PRICE_DIVISIBILITY_UNIT = 1000;
	private static final int PERCENTAGE_MULTIPLIER = 100;
	private static final int ZERO = 0;
	private static final String PROFIT_RATE_FORMAT = "#,##0.0";

	private final int price;

	public Price(int price) {
		validatePrice(price);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getProfitRate(Map<Winning, Integer> winningResult) {
		long totalWinningPrize = Winning.getTotalWinningPrize(winningResult);
		double profitRate = (double) totalWinningPrize / price * PERCENTAGE_MULTIPLIER;
		DecimalFormat decimalFormat = new DecimalFormat(PROFIT_RATE_FORMAT);
		return decimalFormat.format(profitRate);
	}

	private void validatePrice(int price) {
		isDivisibleByThousand(price);
		isPositive(price);
	}

	private void isDivisibleByThousand(int price) {
		if (price % PRICE_DIVISIBILITY_UNIT != ZERO) {
			throw new IllegalArgumentException(INVALID_PRICE_VALUE.getMessage());
		}
	}

	private void isPositive(int price) {
		if (price <= ZERO) {
			throw new IllegalArgumentException(INVALID_PRICE_AMOUNT.getMessage());
		}
	}
}
