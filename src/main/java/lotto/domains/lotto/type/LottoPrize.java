package lotto.domains.lotto.type;

public enum  LottoPrize {
	THREE(3, 5_000, false),
	FOUR(4, 50_000, false),
	FIVE(5, 1_500_000, false),
	FIVE_HAS_BONUS(5, 30_000_000, true),
	SIX(6, 2_000_000_000, false);

	private final int matchCount;
	private final int prize;
	private final boolean hasBonusNumber;

	LottoPrize(int matchCount, int prize, boolean hasBonusNumber) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getPrize() {
		return prize;
	}

	public boolean getHasBonusNumber() {
		return hasBonusNumber;
	}
}
