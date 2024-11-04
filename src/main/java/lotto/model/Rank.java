package lotto.model;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),      // 1등: 6개 숫자 일치 (보너스 숫자는 필요 없음)
    SECOND(5, 1, 30_000_000),     // 2등: 5개 숫자 + 보너스 숫자 일치
    THIRD(5, 0, 1_500_000),      // 3등: 5개 숫자만 일치
    FOURTH(4, 0, 50_000),     // 4등: 4개 숫자만 일치
    FIFTH(3, 0, 5_000),      // 5등: 3개 숫자만 일치
    NONE(0, 0, 0);       // 꽝

    private final int totalWinningNumbers;
    private final int totalBonusNumber;
    private final int winningPrize;

    Rank(int totalWinningNumbers, int totalBonusNumber, int winningPrize) {
        this.totalWinningNumbers = totalWinningNumbers;
        this.totalBonusNumber = totalBonusNumber;
        this.winningPrize = winningPrize;
    }

    // 랭크를 결정하는 메서드
    public static Rank getRankByMatch(int totalWinningNumbers, int totalBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.totalWinningNumbers == totalWinningNumbers && rank.totalBonusNumber == totalBonusNumber) {
                return rank;
            }
        }
        return NONE;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
