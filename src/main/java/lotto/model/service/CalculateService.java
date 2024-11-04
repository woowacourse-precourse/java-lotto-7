package lotto.model.service;

import lotto.model.domain.PurchaseMoney;
import lotto.model.domain.ReturnRate;
import lotto.model.domain.Winning;

public class CalculateService {
	public int calculateLottoCount(PurchaseMoney purchaseMoney) {
		return purchaseMoney.getLottoCount();
	}

	public ReturnRate calculateReturnRate(Winning winning, PurchaseMoney purchaseMoney) {
		return new ReturnRate(purchaseMoney.money(), winning.getTotalPrize());
	}
}
