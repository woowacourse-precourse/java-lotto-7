package lotto.domains.lotto.type;

public enum LottoPrize {
	THREE(3, 5000, false),
	FOUR(4, 50000, false),
	FIVE(5, 1500000, false),
	FIVE_HAS_BONUS(5, 30000000, true),
	SIX(6, 2000000000, false);

	private int matchCount;
	private long prize;
	private boolean hasBonusNumber;

	LottoPrize(int matchCount, long prize, boolean hasBonusNumber) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}
}
