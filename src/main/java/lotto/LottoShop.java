package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LottoShop {
	private static final Supplier<List<Integer>> RANDOM_SIX_NUMBERS =
			() -> Randoms.pickUniqueNumbersInRange(1, 45, 6);

	private static final int AMOUNT_UNIT = 1000;

	public List<Lotto> sell(int money) {
		int quantity = money / AMOUNT_UNIT;

		System.out.println("\n%d개를 구매했습니다.".formatted(quantity));
		return IntStream.range(0, quantity)
				.mapToObj(it -> new Lotto(RANDOM_SIX_NUMBERS.get()))
				.toList();
	}
}
