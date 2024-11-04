package lotto.domain;

public enum Prize {
    NONE(0, 0, false, 0),
    FIFTH_PRIZE(1, 3, false, 5_000),
    FOURTH_PRIZE(2, 4, false, 50_000),
    THRID_PRIZE(3, 5, false, 1_500_000),
    SECOND_PRIZE(4, 5, true, 30_000_000),
    FIRST_PRIZE(5, 6, false, 2_000_000_000);
    private final int index;
    private final int amount;
    private final boolean isBonusNumber;
    private final int reward;

    Prize(int index, int amount, boolean isBonusNumber, int reward) {
        this.index = index;
        this.amount = amount;
        this.isBonusNumber = isBonusNumber;
        this.reward = reward;
    }

    public int compareLottoNumbers(int amount, boolean isBonusNumber) {
        if (amount == 5) {
            if (isBonusNumber) {
                return 4;
            }
            return 3;
        }
        for (Prize prize : Prize.values()) {
            if (prize.amount == amount) {
                return prize.getIndex();
            }
        }
        return 0;
    }
    public Prize getPrize(int index) {
        for(Prize prize : Prize.values()) {
            if(prize.getIndex() == index) {
                return prize;
            }
        }

        return Prize.NONE;
    }

    public int getIndex() {
        return index;
    }

    public int getAmount() {
        return amount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getBonusNumber() {
        return isBonusNumber;
    }
}