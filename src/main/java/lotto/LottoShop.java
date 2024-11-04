package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {
	private static final int MIN_RANGE = 1;
	private static final int MAX_RANGE = 45;
	private static final int LOTTO_SIZE = 6;

	private static final int AMOUNT_UNIT = 1000;

	public List<Lotto> sell(int money) {
		int quantity = money / AMOUNT_UNIT;

		return IntStream.range(0, quantity)
				.mapToObj(it -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE)))
				.toList();
	}
}
