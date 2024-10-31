package lotto.provider;

import static lotto.exception.ExceptionMessage.*;

public class LottoProvider {
	private static final int THOUSAND = 1000;
	private final int numberOfLottos;
	private final int lottoPurchaseAmount;

	public LottoProvider(int lottoPurchaseAmount) {
		validateLottoPurchaseAmount(lottoPurchaseAmount);
		this.lottoPurchaseAmount = lottoPurchaseAmount;
		this.numberOfLottos = lottoPurchaseAmount / THOUSAND;
	}

	private void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
		if (lottoPurchaseAmount % THOUSAND != 0) {
			throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_INPUT.getMessage());
		}
	}
}
