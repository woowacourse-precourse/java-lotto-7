package lotto.validator;

public class LottoTicketValidator {
	public static final int LOTTO_PRICE = 1000;

	public static void validatePurchasePrice(int purchasePrice) {
		validatePositive(purchasePrice);
		validateUnit(purchasePrice);
	}

	public static void validatePositive(int purchasePrice) {
		if (purchasePrice <= 0) {
			throw new IllegalArgumentException("[ERROR] 금액은 양수여야 합니다.");
		}
	}

	public static void validateUnit(int purchasePrice) {
		if (purchasePrice % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
		}
	}
}
