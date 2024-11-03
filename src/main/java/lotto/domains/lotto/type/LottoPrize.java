package lotto.domains.lotto.type;

public enum  LottoPrize {
	THREE(3, 5_000, false),
	FOUR(4, 50_000, false),
	FIVE(5, 1_500_000, false),
	FIVE_HAS_BONUS(5, 30_000_000, true),
	SIX(6, 2_000_000_000, false);

	private int matchCount;
	private long prize;
	private boolean hasBonusNumber;

	LottoPrize(int matchCount, long prize, boolean hasBonusNumber) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public boolean getHasBonusNumber() {
		return hasBonusNumber;
	}
}
