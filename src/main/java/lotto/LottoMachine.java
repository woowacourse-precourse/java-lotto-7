package lotto;

import static lotto.global.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

	private static final int LOTTO_PRICE = 1000;

	public List<Lotto> purchaseLottos(Money money) {
		validatePurchaseMoneyUnit(money);
		int lottoCount = money.getAmount() / LOTTO_PRICE;

		List<Lotto> lottos = generateLottos(lottoCount);

		return lottos;
	}

	private void validatePurchaseMoneyUnit(Money money) {
		if (money.getAmount() % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
		}
	}

	private List<Lotto> generateLottos(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		for(int i = 0; i< lottoCount; i++) {
			List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			lottos.add(new Lotto(lottoNumbers));
		}
		return lottos;
	}
}
