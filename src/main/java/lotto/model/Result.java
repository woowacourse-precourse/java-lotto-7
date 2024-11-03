package lotto.model;

import lotto.util.WinningRank;

public class Result {
    private int three = 0;
    private int four = 0;
    private int five = 0;
    private int bonus = 0;
    private int six = 0;

    public void updateStatistics(WinningRank result) {
        if (result == null) return;

        if (result == WinningRank.THREE) {
            three += 1;
            return;
        }

        if (result == WinningRank.FOUR) {
            four += 1;
            return;
        }

        if (result == WinningRank.FIVE) {
            five += 1;
            return;
        }

        if (result == WinningRank.BONUS) {
            bonus += 1;
            return;
        }

        if (result == WinningRank.SIX) {
            six += 1;
        }
    }

    // 카운트 조회 메서드
    public int getThreeCount() {
        return three;
    }

    public int getFourCount() {
        return four;
    }

    public int getFiveCount() {
        return five;
    }

    public int getBonusCount() {
        return bonus;
    }

    public int getSixCount() {
        return six;
    }
}
