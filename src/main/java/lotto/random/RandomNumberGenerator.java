package lotto.random;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

	private RandomNumberGenerator() {
	}

	private static class Holder {
		private static final RandomNumberGenerator INSTANCE = new RandomNumberGenerator();
	}

	public static RandomNumberGenerator getInstance() {
		return Holder.INSTANCE;
	}

	public List<Integer> generateSortedUniqueNumbers(int startNumber, int endNumber, int size) {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, size);
		return numbers.stream()
			.sorted()
			.toList();
	}
}
