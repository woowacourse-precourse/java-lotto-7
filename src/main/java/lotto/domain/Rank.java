package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(2000000000),
    SECOND(3000000),
    THIRD(150000),
    FOURTH(5000),
    FIFTH(1000);

    private final int prize;

    Rank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank determineRank(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean IsBonus = lotto.contains(bonusNumber);

        switch ((int) matchCount) {
            case 6:
                return FIRST;
            case 5:
                return IsBonus ? SECOND : THIRD; // 삼항 연산자 쓰면 안됨
            case 4:
                return FOURTH;
            case 3:
                return FIFTH;
            default:
                return null;
        }
    }
}
