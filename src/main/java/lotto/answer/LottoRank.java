package lotto.answer;

public enum LottoRank {
	FIRST(6, false, 2000000000),
	SECOND(5, true, 30000000),
	THIRD(5, false, 1500000),
	FOURTH(4, false, 50000),
	FIFTH(1, false, 5000); 
	private final int matchCount;
	private final boolean bonusMatch;
	private final int prizeAmount;

	LottoRank(int matchCount, boolean bonusMatch, int prizeAmount) {
		this.matchCount = matchCount;
		this.bonusMatch = bonusMatch;
		this.prizeAmount = prizeAmount;
	}

	public static LottoRank findRankByMatch(int matchCount, boolean bonusMatch) {
		for (LottoRank rank : values()) {
			if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
				return rank;
			}
		}
		return null;
	}

	public int getPrizeAmount() {
		return prizeAmount;
	}

	public int getMatchCount() {
		return matchCount;
	}
}
