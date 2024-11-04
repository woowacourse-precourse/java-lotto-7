package lotto.domain;

import lotto.Utils;

public enum Rank {
    LOSE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prize;
    private final int matchLotto;

    Rank(int prize, int matchLotto, boolean matchBonus) {
        this.prize = prize;
        this.matchLotto = matchLotto;
    }

    public int getMatchLotto() {
        return matchLotto;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattingPrize() {
        return Utils.numberFomatting(prize);
    }

    public static Rank assign(int matchLotto, boolean matchBonus) {
        if (matchLotto == 6) {
            return FIRST;
        }
        if (matchLotto == 5 && matchBonus) {
            return SECOND;
        }
        if (matchLotto == 5) {
            return THIRD;
        }
        if (matchLotto == 4) {
            return FOURTH;
        }
        if (matchLotto == 3) {
            return FIFTH;
        }
        return LOSE;
    }
}