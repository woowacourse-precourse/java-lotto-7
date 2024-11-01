package lotto.validator;

import lotto.controller.LottoTicketGenerator;

public class LottoTicketValidator {
	public static void validatePurchasePrice(int purchasePrice) {
		if (purchasePrice % LottoTicketGenerator.LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
		}
	}
}