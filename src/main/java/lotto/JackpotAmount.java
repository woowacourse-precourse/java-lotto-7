package lotto;

public enum JackpotAmount {
    FIFTH_PLACE(5_000, 3, false),
    FOURTH_PLACE(50_000, 4, false),
    THIRD_PLACE(1_500_000, 5, false),
    SECOND_PLACE(30_000_000, 5, true),
    FIRST_PLACE(2_000_000_000, 6, false);

    private final int amount;
    private final int matchNumberCount;
    private final boolean bonus;

    JackpotAmount(int amount, int matchNumberCount, boolean bonus) {
        this.amount = amount;
        this.matchNumberCount = matchNumberCount;
        this.bonus = bonus;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static JackpotAmount getMatchLottoJackpotAmount(int jackpotCount, boolean isBonus) {
        for (JackpotAmount value : JackpotAmount.values()) {
            if(value.getMatchNumberCount() == jackpotCount && value.isBonus() == isBonus) {
                return value;
            }
        }
        return null;
    }

}

