package lotto;

import java.util.Arrays;

public enum Prize {

	LOSE(0, 0, false, "0개 일치 - "),
	FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
	FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
	THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
	SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");

	private final int reward;
	private final int matchCount;
	private final boolean bonusMatch;
	private String message;

	Prize(final int reward, int matchCount, boolean bonusMatch, final String message) {
		this.reward = reward;
		this.matchCount = matchCount;
		this.bonusMatch = bonusMatch;
		this.message = message;
	}

	public long getReward() {
		return reward;
	}

	public static Prize getPrize(int matchCount, boolean isBonusMatch) {
		return Arrays.stream(values())
			.filter(prize -> prize.matchCount == matchCount)
			.filter(prize -> !prize.bonusMatch || isBonusMatch)
			.findFirst()
			.orElse(LOSE);
	}

	public static String getReward(int matchCount, boolean isBonusMatch) {
		Prize prize = Prize.getPrize(matchCount, isBonusMatch);
		return prize.message;
	}

}
