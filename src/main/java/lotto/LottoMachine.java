package lotto;

import static lotto.global.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.common.Random;

public class LottoMachine {

	private static final int LOTTO_PRICE = 1000;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;

	public List<Lotto> purchaseLottos(Money money, Random randoms) {
		validatePurchaseMoneyUnit(money);
		int lottoCount = money.getAmount() / LOTTO_PRICE;

		List<Lotto> lottos = generateLottos(lottoCount, randoms);

		return lottos;
	}

	private void validatePurchaseMoneyUnit(Money money) {
		if (money.getAmount() % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
		}
	}

	private List<Lotto> generateLottos(int lottoCount, Random randoms) {
		List<Lotto> lottos = new ArrayList<>();
		for(int i = 0; i< lottoCount; i++) {
			List<Integer> lottoNumbers = randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
			lottos.add(new Lotto(lottoNumbers));
		}
		return lottos;
	}
}
