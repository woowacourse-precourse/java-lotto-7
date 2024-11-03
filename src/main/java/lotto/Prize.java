package lotto;

public enum Prize {
    DRAW(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchedCount;
    public final int prizeMoney;
    private final boolean bonus;

    Prize(int matchedCount, int prizeMoney, boolean bonus) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    Prize(int matchedCount, int prizeMoney) {
        this(matchedCount, prizeMoney, false);
    }

    @Override
    public String toString() {
        if (this.prizeMoney == 0) {
            return null;
        }

        String string = matchedCount + "개 일치";

        if (this.bonus) {
            string += ", 보너스 볼 일치";
        }

        string += String.format(" (%,d원)", prizeMoney);
        return string;
    }

    public static Prize getPrize(Lotto lotto, WinningLotto winningLotto) {
        int matchResult = lotto.match(winningLotto);
        if (matchResult == SECOND.matchedCount && lotto.getNumbers().contains(winningLotto.getBonusNum())) {
            return SECOND;
        }
        for (Prize value : Prize.values()) {
            if (value.matchedCount == matchResult) {
                return value;
            }
        }
        return DRAW;
    }


}
