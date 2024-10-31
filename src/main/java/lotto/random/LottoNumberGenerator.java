package lotto.random;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 45;
	private static final int NUMBER_SIZE = 6;

	private LottoNumberGenerator() {
	}

	private static class Holder {
		private static final LottoNumberGenerator INSTANCE = new LottoNumberGenerator();
	}

	public static LottoNumberGenerator getInstance() {
		return Holder.INSTANCE;
	}

	public List<Integer> generateUniqueRandomNumbers() {
		return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_SIZE);
	}
}
