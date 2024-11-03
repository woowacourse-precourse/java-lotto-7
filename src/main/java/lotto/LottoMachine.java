package lotto;

import static lotto.global.ErrorMessage.*;

import java.util.List;

public class LottoMachine {

	private static final int MONEY_UNIT = 1000;

	public List<Lotto> purchaseLottos(Money money) {
		validatePurchaseMoneyUnit(money);


	}

	private void validatePurchaseMoneyUnit(Money money) {
		if (money.getAmount() % MONEY_UNIT != 0) {
			throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
		}
	}
}
