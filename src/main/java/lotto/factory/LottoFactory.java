package lotto.factory;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.domain.Lotto;

public class LottoFactory {

	private static final int MIN_RANGE_NUMBER = 1;
	private static final int MAX_RANGE_NUMBER = 45;
	private static final int NUMBER_COUNT = 6;

	public static Lotto of() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER, NUMBER_COUNT);
		return Lotto.of(numbers);
	}
}
