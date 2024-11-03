package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {
	FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
	SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
	THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
	FORTH(4, 50000, "4개 일치 (50,000원)"),
	FIFTH(3, 5000, "3개 일치 (5,000원)"),
	;

	private final int matchCount;
	private final long money;
	private final String message;

	Rank(int matchCount, long money, String message) {
		this.matchCount = matchCount;
		this.money = money;
		this.message = message;
	}

	public static Optional<Rank> of(int matchCount, boolean matchBonus) {
		return Arrays.stream(values())
			.filter(v -> v.matches(matchCount, matchBonus))
			.findFirst();
	}

	public long getMoney() {
		return money;
	}

	public String getMessage() {
		return message;
	}

	public static List<Rank> getRanks() {
		return Arrays.stream(values())
			.toList();
	}

	private boolean matches(int matchCount, boolean matchBonus) {
		if (this == SECOND) {
			return matchCount == 5 && matchBonus;
		}
		if (this == THIRD) {
			return matchCount == 5 && !matchBonus;
		}
		return this.matchCount == matchCount;
	}
}
