package lotto.domain;

import static lotto.common.ErrorMessage.*;

public class PurchaseAmount {

	private static final int LOTTO_PRICE_UNIT = 1000;

	private final int purchaseAmount;

	private PurchaseAmount(int purchaseAmount) {
		validatePurchaseAmountRange(purchaseAmount);
		validatePurchaseAmountUnit(purchaseAmount);

		this.purchaseAmount = purchaseAmount;
	}

	public static PurchaseAmount from(int purchaseAmount) {
		return new PurchaseAmount(purchaseAmount);
	}

	private void validatePurchaseAmountRange(int purchaseAmount) {
		if(purchaseAmount <= 0) {
			throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT.getComment());
		}
	}

	private void validatePurchaseAmountUnit(int purchaseAmountUnit) {
		if(purchaseAmountUnit % LOTTO_PRICE_UNIT != 0) {
			throw new IllegalArgumentException(NOT_FIT_LOTTO_PRICE_UNIT_PURCHASE_AMOUNT.getComment());
		}
	}

	public int getPurchaseLottoCount() {
		return purchaseAmount / LOTTO_PRICE_UNIT;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}
}
