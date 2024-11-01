package lotto;

public enum Prize {
    FIFTH("5등", 3, 5_000),
    FOURTH("4등", 4, 50_000),
    THIRD("3등", 5, 1_500_000, false),
    SECOND("2등", 5, 30_000_000, true),
    FIRST("1등", 6, 2_000_000_000);

    private final String explain;
    private final int matchedCount;
    private final int prizeMoney;
    private final boolean bonus;

    Prize(String explain, int matchedCount, int prizeMoney, boolean bonus) {
        this.explain = explain;
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    Prize(String explain, int matchedCount, int prizeMoney) {
        this(explain, matchedCount, prizeMoney, false);
    }

    @Override
    public String toString() {
        String string = matchedCount + "개 일치 ";

        if (this.bonus) {
            string += ", 보너스 볼 일치 ";
        }

        string += String.format("(%,d원)", prizeMoney);
        return string;
    }

    public static Prize getPrize(Lotto lotto, WinningLotto winningLotto) {
        int matchResult = lotto.match(winningLotto);
        if (matchResult == 5 && lotto.getNumbers().contains(winningLotto.getBonusNum())) {
            return SECOND;
        }
        for (Prize value : Prize.values()) {
            if (value.matchedCount == matchResult) {
                return value;
            }
        }
        return null;
    }


}
