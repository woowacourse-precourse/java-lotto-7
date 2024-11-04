package lotto.util;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoGenerator {
	private static final int LOTTO_PRICE = 1000;
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	public static List<Lotto> purchaseLottos(int purchaseAmount) {
		int count = purchaseAmount / LOTTO_PRICE;
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT)));
		}

		return lottos;
	}
}
