package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Winning {
	NONE(0, 0L, false),
	FIFTH(3, 5000L, false),
	FOURTH(4, 50000L, false),
	THIRD(5, 1500000L, false),
	SECOND(5, 30000000L, true),
	FIRST(6, 2000000000L, false);

	private static final int INITIAL_VALUE = 0;

	private final int count;
	private final long prize;
	private final boolean hasBonusNumber;

	Winning(int count, long prize, boolean hasBonusNumber) {
		this.count = count;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}

	public int getCount() {
		return count;
	}

	public long getPrize() {
		return prize;
	}

	public boolean getHasBonusNumber() {
		return hasBonusNumber;
	}

	public static Map<Winning, Integer> initializeWinningResults() {
		return Arrays.stream(Winning.values())
				.collect(Collectors.toMap(winning -> winning, winning -> INITIAL_VALUE));
	}

	public static Winning getWinningResult(long count, boolean hasBonusNumber) {
		Winning result = Arrays.stream(Winning.values())
				.filter(winning -> winning.count == count)
				.findFirst()
				.orElse(NONE);
		result = checkIfSecond(result, hasBonusNumber);
		return result;
	}

	public static long getTotalWinningPrize(Map<Winning, Integer> winningResult) {
		return winningResult.entrySet().stream()
				.mapToLong(winning -> winning.getKey().prize * winning.getValue())
				.sum();
	}

	private static Winning checkIfSecond(Winning result, boolean hasBonusNumber) {
		if (result.count == SECOND.count && hasBonusNumber == SECOND.hasBonusNumber) {
			return SECOND;
		}
		return result;
	}
}
