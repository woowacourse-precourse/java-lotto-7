package lotto.model;

public enum Winning {

	private final int count;
	private final int prize;
	private final boolean hasBonusNumber;

	Winning(int count, int prize, boolean hasBonusNumber) {
		this.count = count;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}
}
