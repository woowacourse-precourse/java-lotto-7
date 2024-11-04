package lotto;

import java.util.Arrays;

public enum Prize {
	FIFTH(3, 5_000L, false),
	FOURTH(4, 50_000L, false),
	THIRD(5, 1_500_000L, false),
	SECOND(5, 30_000_000L, true),
	FIRST(6, 2_000_000_000L, false),
	NONE(0, 0, false);

	private final int matchCount;
	private final long amount;
	private final boolean bonus;

	Prize(int matchCount, long amount, boolean bonus) {
		this.matchCount = matchCount;
		this.amount = amount;
		this.bonus = bonus;
	}

	public static Prize rank(int matchCount, boolean hasBonus) {
		return Arrays.stream(Prize.values())
				.filter(prize -> prize.isMatch(matchCount, hasBonus))
				.findFirst()
				.orElse(NONE);
	}

	public long getAmount() {
		return amount;
	}

	private boolean isMatch(int matchCount, boolean hasBonus) {
		return this.matchCount == matchCount && this.bonus == hasBonus;
	}
}
