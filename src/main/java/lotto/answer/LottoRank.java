package lotto.answer;

public enum LottoRank {
	FIRST(6, false, 2000000000) {
		@Override
		void printInfo() {
			System.out.println(getMatchCount() + MATCH_MESSAGE + "(" + getPrizeAmount() + "-");
		}
	},
	SECOND(5, true, 30000000) {
		@Override
		void printInfo() {
			System.out.println(getMatchCount() + MATCH_MESSAGE + BONUS_MATCH_MESSAGE + "(" + getPrizeAmount() + "-");
		}
	},
	THIRD(5, false, 1500000) {
		@Override
		void printInfo() {
			System.out.println(getMatchCount() + MATCH_MESSAGE + "(" + getPrizeAmount() + "-");
		}
	},
	FOURTH(4, false, 50000) {
		@Override
		void printInfo() {
			System.out.println(getMatchCount() + MATCH_MESSAGE + "(" + getPrizeAmount() + "-");
		}
	},
	FIFTH(1, false, 5000) {
		@Override
		void printInfo() {
			System.out.println(getMatchCount() + MATCH_MESSAGE + "(" + getPrizeAmount() + "-");
		}
	};
	private static final String MATCH_MESSAGE = "개 일치";
	private static final String BONUS_MATCH_MESSAGE = "보너스 볼 일치";
	private static final String WON = "원";
	private static final String AMOUNT = "개";
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

	abstract void printInfo();
}
