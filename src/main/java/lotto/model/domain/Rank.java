package lotto.model.domain;

import java.util.Arrays;

public enum Rank {

	FIFTH(3, false, 5_000),
	FOURTH(4, false, 50_000),
	THIRD(5, false, 1_500_000),
	SECOND(5, true, 30_000_000),
	FIRST(6, false, 2_000_000_000),
	;

	private final int matchCount;
	private final boolean requiredBonus;
	private final int prize;

	Rank(int matchCount, boolean requiredBonus, int prize) {
		this.matchCount = matchCount;
		this.requiredBonus = requiredBonus;
		this.prize = prize;
	}

	public static Rank getRank(int matchCount, boolean requiredBonus) {
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.matchCount == matchCount && rank.requiredBonus == requiredBonus)
			.findFirst()
			.orElse(null);
	}

	public int getPrize() {
		return prize;
	}

	public int getMatchCount() {
		return matchCount;
	}
}
