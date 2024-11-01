package lotto.model;

public enum LottoRanking {

    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FORTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    MISS(0, 0, "");

    private int countOfMatch;
    private int winningAmount;
    private String message;
    private int winCount;
    private static final String ERROR_MESSAGE = "일치하는 결과값이 없습니다.";

    LottoRanking(int countOfMatch, int winningAmount, String message) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static LottoRanking valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 3) {
            return MISS;
        }

        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        for (LottoRanking ranking : values()) {
            if (countOfMatch == ranking.getCountOfMatch() && ranking != SECOND) {
                return ranking;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMessage() {
        return message;
    }

    public int getWinCount() {
        return winCount;
    }

    public void win() {
        winCount++;
    }
}
