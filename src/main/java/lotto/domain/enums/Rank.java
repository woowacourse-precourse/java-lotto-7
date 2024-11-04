package lotto.domain.enums;

import java.util.Optional;

public enum Rank {

	FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
	FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
	FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
	;

	Rank(int matchCount, int prizeMoney, String winningMessage) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
		this.winningMessage = winningMessage;
	}

	private final int matchCount;
	private final int prizeMoney;
	private final String winningMessage;

	public static Optional<Rank> judgeBy(int winCount, boolean isBonusNumberWin) {
		if (winCount == FIRST.matchCount) {
			return Optional.of(Rank.FIRST);
		} else if (winCount == SECOND.matchCount && isBonusNumberWin) {
			return Optional.of(Rank.SECOND);
		} else if (winCount == THIRD.matchCount) {
			return Optional.of(Rank.THIRD);
		} else if (winCount == FOURTH.matchCount) {
			return Optional.of(Rank.FOURTH);
		} else if (winCount == FIFTH.matchCount) {
			return Optional.of(Rank.FIFTH);
		}

		return Optional.empty();
	}

	public int getPrizeMoney(){
		return prizeMoney;
	}

	public String getWinningMessage(){
		return winningMessage;
	}
}
