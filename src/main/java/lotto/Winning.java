package lotto;

public enum Winning {

	NONE(0, 0, 0, "낙첨입니다. (0원) - "), FIFTH(1, 3, 5_000, "3개 일치 (5,000원) - "),
	FOURTH(2, 4, 50_000, "4개 일치 (50,000원) - "), THIRD(3, 5, 1_500_000, "5개 일치 (1,500,000원) - "),
	SECOND(4, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST(5, 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

	private final int index;
	private final int count;
	private final int winningAmount;
	private final String message;

	Winning(int index, int count, int winningAmount, String message) {
		this.index = index;
		this.count = count;
		this.winningAmount = winningAmount;
		this.message = message;
	}

	public int getIndex() {
		return index;
	}

	public int getCount() {
		return count;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public String getMessage() {
		return message;
	}

}
