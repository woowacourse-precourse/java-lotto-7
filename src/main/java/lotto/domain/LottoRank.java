package lotto.domain;

public enum LottoRank {
    FIFTH_RANK(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH_RANK(4, 50000, "4개 일치 (50,000원) - %d개"),
    THIRD_RANK(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND_RANK(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_RANK(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    OTHER_RANK(0, 0, "");

    private final int correctCount;
    private final int prizeAmount;
    private final String message;

    LottoRank(int correctCount, int prizeAmount, String message) {
        this.correctCount = correctCount;
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public static LottoRank setUpRankByCorrectCount(int correctCount, boolean correctBonusNumber) {
        if (correctCount == 5) {
            return setUpRankWithFiveCorrectCount(correctBonusNumber);
        }
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.correctCount == correctCount) {
                return lottoRank;
            }
        }
        return OTHER_RANK;
    }

    private static LottoRank setUpRankWithFiveCorrectCount(boolean correctBonusNumber) {
        if (correctBonusNumber) {
            return SECOND_RANK;
        }
        return THIRD_RANK;
    }

    public int getPrizeAmount() {
        return this.prizeAmount;
    }

    public String getMessage() {
        return this.message;
    }
}
