package lotto;

import java.util.List;

public enum Rank {
    FIFTH(3, false, "5,000원"),                 // 3개 일치
    FOURTH(4, false, "50,000원"),               // 4개 일치
    THIRD(5, false,  "1,500,000원"),             // 5개 일치
    SECOND(5, true, "30,000,000원"),           // 5개 일치 + 보너스 번호
    FIRST(6, false, "2,000,000,000원");         // 6개 일치

    int balls;
    String winningPrize;
    boolean bonus;

    Rank(int balls, boolean bonus, String winningPrize) {
        this.balls = balls;
        this.bonus = bonus;
        this.winningPrize = winningPrize;
    }

    int getBalls() {
        return balls;
    }

    boolean getBonus() {
        return bonus;
    }

    String getWinningPrize() {
        return winningPrize;
    }
}


