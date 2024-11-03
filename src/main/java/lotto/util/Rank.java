package lotto.util;

public enum Rank {
    FIFTH(3, false, 5_000),                 // 3개 일치
    FOURTH(4, false, 50_000),               // 4개 일치
    THIRD(5, false,  1_500_000),             // 5개 일치
    SECOND(5, true, 30_000_000),           // 5개 일치 + 보너스 번호
    FIRST(6, false, 2_000_000_000);         // 6개 일치

    int balls;
    int winningPrize;
    boolean bonus;

    Rank(int balls, boolean bonus, int winningPrize) {
        this.balls = balls;
        this.bonus = bonus;
        this.winningPrize = winningPrize;
    }

    int getBalls() {
        return balls;
    }

    int getWinningPrize() {
        return winningPrize;
    }

    public static Rank getRank(int balls, boolean bonus) {
        for (Rank rank : values()) {
            if (rank.balls == balls && rank.bonus == bonus) {
                return rank;
            }
        }
        return null;
    }

}


