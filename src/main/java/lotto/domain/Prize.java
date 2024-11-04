package lotto.domain;

import java.util.Arrays;

public enum Prize {

	FIRST(6, false, 2_000_000_000),
	SECOND(5, true, 30_000_000),
	THIRD(5, false, 1_500_000),
	FOURTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	NOTHING(0, false, 0);

	private final int winningNumberHitCount;
	private final boolean isBonusRequired;
	private final long prizeMoney;

	Prize(int winningNumberHitCount, boolean isBonusRequired, long prizeMoney) {
		this.winningNumberHitCount = winningNumberHitCount;
		this.isBonusRequired = isBonusRequired;
		this.prizeMoney = prizeMoney;
	}

	public static Prize valueOfWinningNumberHitCountAndBonusHit(int winningNumberHitCount, boolean isBonusHit) {
		if (winningNumberHitCount == SECOND.getWinningNumberHitCount() && isBonusHit) {
			return SECOND;
		}

		return Arrays.stream(Prize.values())
			.filter(prize -> prize.winningNumberHitCount == winningNumberHitCount && !prize.isBonusRequired)
			.findAny()
			.orElse(NOTHING);
	}

	public int getWinningNumberHitCount() {
		return winningNumberHitCount;
	}

	public boolean isBonusRequired() {
		return isBonusRequired;
	}

	public long getPrizeMoney() {
		return prizeMoney;
	}
}
