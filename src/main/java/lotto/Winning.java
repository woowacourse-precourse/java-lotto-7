package lotto;

public enum Winning {
    
	NONE(0, 0, "낙첨입니다. (0원) - "),
	FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
	FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int count;
    private final int winningAmount;
    private final String message;
    
    Winning(int count, int winningAmount, String message) {
        this.count = count;
        this.winningAmount = winningAmount;
        this.message = message;
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
