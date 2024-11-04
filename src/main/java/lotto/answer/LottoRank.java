package lotto.answer;

public enum LottoRank {
	FIFTH(3, false, 5000, "3개 일치 (5,000원) - ") {
		@Override
		public void printInfo() {
			System.out.print("3개 일치 (5,000원) - ");
		}
	},
	FOURTH(4, false, 50000, "4개 일치 (50,000원) - ") {
		@Override
		public void printInfo() {
			System.out.print("4개 일치 (50,000원) - ");
		}
	},
	THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - ") {
		@Override
		public void printInfo() {
			System.out.print("5개 일치 (1,500,000원) - ");
		}
	},
	SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ") {
		@Override
		public void printInfo() {
			System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
		}
	},
	FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ") {
		@Override
		public void printInfo() {
			System.out.print("6개 일치 (2,000,000,000원) - ");
		}
	};
	private static final String MATCH_MESSAGE = "개 일치";
	private static final String BONUS_MATCH_MESSAGE = "보너스 볼 일치";
	private static final String WON = "원";
	private static final String AMOUNT = "개";
	private final int matchCount;
	private final boolean bonusMatch;
	private final int prizeAmount;
	private final String message;

	LottoRank(int matchCount, boolean bonusMatch, int prizeAmount, String message) {
		this.matchCount = matchCount;
		this.bonusMatch = bonusMatch;
		this.prizeAmount = prizeAmount;
		this.message = message;
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

	public abstract void printInfo();
}
