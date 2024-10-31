package lotto.model;

public enum LottoRank {
	FIRST(6, false, 2_000_000_000),
	SECOND(5, true, 30_000_000),
	THIRD(5, false, 1_500_000),
	FORTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	BOOM(0, false, 0);

	private final int matchCount;
	private final boolean bonusMatch;
	private final int prize;

	LottoRank(int matchCount, boolean bonusMatch, int prize) {
		this.matchCount = matchCount;
		this.bonusMatch = bonusMatch;
		this.prize = prize;
	}

	public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
		for (LottoRank rank : values()) {
			if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
				return rank;
			}
		}
		return BOOM;
	}
}
